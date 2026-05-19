// ============================================================
// CUSTOMER CRUD
// ============================================================

async function loadCustomers() {
    const response = await fetch("/api/customer");
    if (!response.ok) { console.error("Failed to load customers"); return; }
    const data = await response.json();
    const tbody = document.getElementById("tableBody");
    if (!tbody) return;
    tbody.innerHTML = "";
    data.data.forEach(c => {
        tbody.innerHTML += `
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.email}</td>
                <td>${c.phone}</td>
                <td>${c.address}</td>
                <td>
                    <button onclick="deleteCustomer(${c.id})" style="background:#dc2626">Delete</button>
                    <button onclick="openEditCustomer(${c.id},'${c.name}','${c.email}',${c.phone},'${c.address}')">Edit</button>
                </td>
            </tr>`;
    });
}

async function addCustomer(event) {
    event.preventDefault();
    const customer = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phone: parseInt(document.getElementById("phone").value),
        address: document.getElementById("address").value
    };
    const response = await fetch("/api/customer", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(customer)
    });
    if (response.ok) {
        alert("Customer Added Successfully");
        event.target.reset();
        loadCustomers();
    } else {
        const err = await response.json().catch(() => null);
        alert("Failed to Add Customer: " + (err?.message || response.status));
    }
}

async function deleteCustomer(id) {
    if (!confirm("Delete customer #" + id + "?")) return;
    const response = await fetch("/api/customer/" + id, { method: "DELETE" });
    if (response.ok) {
        alert("Customer Deleted");
        loadCustomers();
    } else {
        alert("Failed to delete customer");
    }
}

async function openEditCustomer(id, name, email, phone, address) {
    const newName    = prompt("Name:", name);       if (newName    === null) return;
    const newEmail   = prompt("Email:", email);     if (newEmail   === null) return;
    const newPhone   = prompt("Phone:", phone);     if (newPhone   === null) return;
    const newAddress = prompt("Address:", address); if (newAddress === null) return;
    const response = await fetch("/api/customer", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ id, name: newName, email: newEmail, phone: parseInt(newPhone), address: newAddress })
    });
    if (response.ok) { alert("Customer Updated"); loadCustomers(); }
    else { alert("Failed to update customer"); }
}

// ============================================================
// SUPPLIER CRUD
// ============================================================

async function loadSuppliers() {
    const response = await fetch("/api/supplier");
    if (!response.ok) { console.error("Failed to load suppliers"); return; }
    const data = await response.json();
    const tbody = document.getElementById("tableBody");
    if (!tbody) return;
    tbody.innerHTML = "";
    data.data.forEach(s => {
        tbody.innerHTML += `
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.phone}</td>
                <td>${s.address}</td>
                <td>
                    <button onclick="deleteSupplier(${s.id})" style="background:#dc2626">Delete</button>
                    <button onclick="openEditSupplier(${s.id},'${s.name}','${s.email}',${s.phone},'${s.address}')">Edit</button>
                </td>
            </tr>`;
    });
}

async function addSupplier(event) {
    event.preventDefault();
    const supplier = {
        name: document.getElementById("name").value,
        email: document.getElementById("email").value,
        phone: parseInt(document.getElementById("phone").value),
        address: document.getElementById("address").value
    };
    const response = await fetch("/api/supplier", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(supplier)
    });
    if (response.ok) {
        alert("Supplier Added Successfully");
        event.target.reset();
        loadSuppliers();
    } else {
        alert("Failed to Add Supplier");
    }
}

async function deleteSupplier(id) {
    if (!confirm("Delete supplier #" + id + "?")) return;
    const response = await fetch("/api/supplier/" + id, { method: "DELETE" });
    if (response.ok) { alert("Supplier Deleted"); loadSuppliers(); }
    else { alert("Failed to delete supplier"); }
}

async function openEditSupplier(id, name, email, phone, address) {
    const newName    = prompt("Name:", name);       if (newName    === null) return;
    const newEmail   = prompt("Email:", email);     if (newEmail   === null) return;
    const newPhone   = prompt("Phone:", phone);     if (newPhone   === null) return;
    const newAddress = prompt("Address:", address); if (newAddress === null) return;
    const response = await fetch("/api/supplier", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ id, name: newName, email: newEmail, phone: parseInt(newPhone), address: newAddress })
    });
    if (response.ok) { alert("Supplier Updated"); loadSuppliers(); }
    else { alert("Failed to update supplier"); }
}

// ============================================================
// PRODUCT CRUD
// ============================================================

async function loadProducts() {
    const response = await fetch("/api/product");
    if (!response.ok) { console.error("Failed to load products"); return; }
    const data = await response.json();
    const tbody = document.getElementById("tableBody");
    if (!tbody) return;
    tbody.innerHTML = "";
    data.data.forEach(p => {
        tbody.innerHTML += `
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>${p.quantity}</td>
                <td>
                    <button onclick="deleteProduct(${p.id})" style="background:#dc2626">Delete</button>
                </td>
            </tr>`;
    });
}

async function addProduct(event) {
    event.preventDefault();
    const supplierId = document.getElementById("supplierId").value;
    const orderId    = document.getElementById("orderId").value;
    const product = {
        name:     document.getElementById("name").value,
        price:    parseFloat(document.getElementById("price").value),
        quantity: parseInt(document.getElementById("quantity").value)
    };
    const response = await fetch(`/api/product/${supplierId}/${orderId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(product)
    });
    if (response.ok) {
        alert("Product Added Successfully");
        event.target.reset();
        loadProducts();
    } else {
        alert("Failed to Add Product");
    }
}

async function deleteProduct(id) {
    if (!confirm("Delete product #" + id + "?")) return;
    const response = await fetch("/api/product/" + id, { method: "DELETE" });
    if (response.ok) { alert("Product Deleted"); loadProducts(); }
    else { alert("Failed to delete product"); }
}

// ============================================================
// ORDER CRUD
// ============================================================

async function loadOrders() {
    const response = await fetch("/api/orders");
    if (!response.ok) { console.error("Failed to load orders"); return; }
    const data = await response.json();
    const tbody = document.getElementById("tableBody");
    if (!tbody) return;
    tbody.innerHTML = "";
    data.data.forEach(o => {
        tbody.innerHTML += `
            <tr>
                <td>${o.id}</td>
                <td>${o.trackingNumber || '-'}</td>
                <td>${o.orderDate || '-'}</td>
                <td>${o.status || '-'}</td>
                <td>
                    <button onclick="deleteOrder(${o.id})" style="background:#dc2626">Delete</button>
                </td>
            </tr>`;
    });
}

async function addOrder(event) {
    event.preventDefault();
    const customerId = document.getElementById("customerId").value;
    const order = {
        trackingNumber: document.getElementById("trackingNumber").value,
        orderDate:      document.getElementById("orderDate").value,
        status:         document.getElementById("status").value
    };
    const response = await fetch(`/api/orders/${customerId}`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(order)
    });
    if (response.ok) {
        alert("Order Added Successfully");
        event.target.reset();
        loadOrders();
    } else {
        alert("Failed to Add Order");
    }
}

async function deleteOrder(id) {
    if (!confirm("Delete order #" + id + "?")) return;
    const response = await fetch("/api/orders/" + id, { method: "DELETE" });
    if (response.ok) { alert("Order Deleted"); loadOrders(); }
    else { alert("Failed to delete order"); }
}

// ============================================================
// AUTO-LOAD on page open
// ============================================================
window.addEventListener("DOMContentLoaded", () => {
    const path = window.location.pathname;
    if (path.includes("customer")) loadCustomers();
    if (path.includes("supplier")) loadSuppliers();
    if (path.includes("product"))  loadProducts();
    if (path.includes("order"))    loadOrders();
});
