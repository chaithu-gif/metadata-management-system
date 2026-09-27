import { useState } from "react";
import Sidebar from "./components/Sidebar";
import Navbar from "./components/Navbar";
import CustomerList from "./components/CustomerList";
import CustomerForm from "./components/CustomerForm";
import "./App.css";

function App() {
  const [page, setPage] = useState("customers");
  const [refresh, setRefresh] = useState(0);

  return (
    <div className="app">
      <Navbar />

      <div className="main-layout">
        <Sidebar />

        <main className="content">

          {page === "customers" && (
            <CustomerList
              onAddCustomer={() => setPage("add-customer")}
              refresh={refresh}
            />
          )}

          {page === "add-customer" && (
            <CustomerForm
              onBack={() => {
                setRefresh(refresh + 1);
                setPage("customers");
              }}
            />
          )}

        </main>
      </div>
    </div>
  );
}

export default App;