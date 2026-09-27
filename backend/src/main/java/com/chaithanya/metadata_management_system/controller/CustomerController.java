package com.chaithanya.metadata_management_system.controller;
import java.util.List;
import java.util.Map;
import com.chaithanya.metadata_management_system.model.Customer;
import com.chaithanya.metadata_management_system.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import com.chaithanya.metadata_management_system.model.Customer;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping
public Customer createCustomer(@RequestBody Map<String, Object> request) {
    return customerService.createCustomer(request);
}
@GetMapping
public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
}
@GetMapping("/{id}")
public Customer getCustomer(@PathVariable String id) {
    return customerService.getCustomer(id);
}
@PutMapping("/{id}")
public Customer updateCustomer(
        @PathVariable String id,
        @RequestBody Customer customer) {

    return customerService.updateCustomer(id, customer);
}
@DeleteMapping("/{id}")
public void deleteCustomer(@PathVariable String id) {
    customerService.deleteCustomer(id);
}

}