package com.chaithanya.metadata_management_system.service;

import tools.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;
import com.chaithanya.metadata_management_system.model.Metadata;
import com.chaithanya.metadata_management_system.repository.MetadataRepository;
import com.chaithanya.metadata_management_system.model.Customer;
import com.chaithanya.metadata_management_system.repository.CustomerRepository;
import com.chaithanya.metadata_management_system.exception.ValidationException;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import com.chaithanya.metadata_management_system.model.MetadataField;
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
private final MetadataRepository metadataRepository;
private final ObjectMapper objectMapper;
   public CustomerService(
        CustomerRepository customerRepository,
        MetadataRepository metadataRepository,
        ObjectMapper objectMapper) {

    this.customerRepository = customerRepository;
    this.metadataRepository = metadataRepository;
    this.objectMapper = objectMapper;
}
    public Customer createCustomer(Map<String, Object> request) {

    Metadata metadata = metadataRepository.findAll()
            .stream()
            .filter(m -> "Customer".equalsIgnoreCase(m.getObjectName()))
            .filter(m -> m.getFields() != null && !m.getFields().isEmpty())
            .findFirst()
            .orElseThrow(() ->
                    new RuntimeException("Customer metadata not found"));

    for (MetadataField field : metadata.getFields()) {

        String fieldName = field.getName();
        Object value = request.get(fieldName);

        // Required validation
        if (field.isRequired()) {

            if (value == null
                    || (value instanceof String
                    && ((String) value).isBlank())) {

                throw new ValidationException(
                        fieldName + " is required");
            }
        }

        // Length validation
        if (field.getLength() != null && value != null) {

            if (value instanceof String
                    && ((String) value).length() > field.getLength()) {

                throw new ValidationException(
                        fieldName + " exceeds maximum length of "
                                + field.getLength());
            }
        }

        // Unique validation
        if (field.isUnique() && value != null) {

            if ("customerId".equals(fieldName)
                    && customerRepository.existsById(value.toString())) {

                throw new ValidationException(
                        "customerId already exists");
            }

            if ("email".equals(fieldName)
                    && customerRepository.existsByEmail(value.toString())) {

                throw new ValidationException(
                        "email already exists");
            }
        }

        // Data type validation
        if (value != null && field.getDataType() != null) {

            String dataType = field.getDataType();

            if ("String".equalsIgnoreCase(dataType)
                    && !(value instanceof String)) {

                throw new ValidationException(
                        fieldName + " must be of type String");
            }

            if ("Integer".equalsIgnoreCase(dataType)
                    && !(value instanceof Integer)) {

                throw new ValidationException(
                        fieldName + " must be of type Integer");
            }

            if ("Double".equalsIgnoreCase(dataType)
                    && !(value instanceof Double)) {

                throw new ValidationException(
                        fieldName + " must be of type Double");
            }
        }
    }

    // Convert Map into Customer object
    Customer customer =
            objectMapper.convertValue(request, Customer.class);

    // Auditing
    LocalDateTime now = LocalDateTime.now();

    customer.setCreatedAt(now);
    customer.setCreatedBy("SYSTEM");

    customer.setUpdatedAt(now);
    customer.setUpdatedBy("SYSTEM");

    return customerRepository.save(customer);
}
    public List<Customer> getAllCustomers() {
    return customerRepository.findAll();
}
    public Customer getCustomer(String id) {
    return customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));
}
public Customer updateCustomer(String id, Customer customer) {
    Customer existingCustomer = customerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

    existingCustomer.setFirstName(customer.getFirstName());
    existingCustomer.setEmail(customer.getEmail());
    existingCustomer.setPhone(customer.getPhone());
    existingCustomer.setUpdatedAt(LocalDateTime.now());
    existingCustomer.setUpdatedBy("SYSTEM");
    return customerRepository.save(existingCustomer);
}
public void deleteCustomer(String id) {
    customerRepository.deleteById(id);
}
}