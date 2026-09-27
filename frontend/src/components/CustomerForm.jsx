import { useEffect, useState } from "react";

function CustomerForm({ onBack }) {
  const [fields, setFields] = useState([]);
  const [formData, setFormData] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetch("http://localhost:8080/metadata/customer")
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to fetch metadata");
        }

        return response.json();
      })
      .then((data) => {
        setFields(data.fields);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching metadata:", error);
        setLoading(false);
      });
  }, []);

  const handleChange = (event, fieldName) => {
    setFormData({
      ...formData,
      [fieldName]: event.target.value
    });
  };

  const handleSubmit = () => {
  fetch("http://localhost:8080/customers", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(formData)
  })
    .then((response) => {
      if (!response.ok) {
        throw new Error("Failed to create customer");
      }

      return response.json();
    })
    .then((data) => {
      console.log("Customer created:", data);
      alert("Customer created successfully!");
    })
    .catch((error) => {
      console.error("Error creating customer:", error);
      alert("Failed to create customer");
    });
};

  if (loading) {
    return <p>Loading form...</p>;
  }

  return (
    <div>
      <h1>Create Customer</h1>
    <button onClick={onBack}>
  ← Back to Customers
    </button>
      {fields.map((field) => (
  <div key={field.name}>
    <label htmlFor={field.name}>
      {field.name}
    </label>

    <input
      id={field.name}
      name={field.name}
      type="text"
      value={formData[field.name] || ""}
      placeholder={field.name}
      autoComplete={
        field.name === "customerId"
          ? "off"
          : field.name === "firstName"
          ? "given-name"
          : field.name === "email"
          ? "email"
          : field.name === "phone"
          ? "tel"
          : "off"
      }
      onChange={(event) => handleChange(event, field.name)}
    />
  </div>
))}

      <button onClick={handleSubmit}>
        Create Customer
      </button>
    </div>
  );
}

export default CustomerForm;