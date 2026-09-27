import { useEffect, useState } from "react";

function CustomerList({ onAddCustomer , refresh}) {
  const [customers, setCustomers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/customers")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch customers");
        }

        return response.json();
      })
      .then((data) => {
        setCustomers(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching customers:", error);
        setError("Unable to load customers");
        setLoading(false);
      });
  }, [refresh]);

  if (loading) {
    return <p>Loading customers...</p>;
  }

  if (error) {
    return <p>{error}</p>;
  }

  return (
    <div className="customer-page">
      <div className="page-header">
        <div>
          <h1>Customers</h1>
          <p>Manage customer records</p>
        </div>

        <button
  className="add-button"
  onClick={onAddCustomer}
>
  + Add Customer
</button>
      </div>

      <div className="customer-table-container">
        <table className="customer-table">
          <thead>
            <tr>
              <th>Customer ID</th>
              <th>First Name</th>
              <th>Email</th>
              <th>Phone</th>
              <th>Created By</th>
            </tr>
          </thead>

          <tbody>
            {customers.map((customer) => (
              <tr key={customer.customerId}>
                <td>{customer.customerId}</td>
                <td>{customer.firstName}</td>
                <td>{customer.email}</td>
                <td>{customer.phone}</td>
                <td>{customer.createdBy}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default CustomerList;