# SparePartWala - Spare Parts Inventory Management System

## 📌 Overview

SparePartWala is a full-stack web-based application designed to automate and simplify the spare parts supply chain process for automobiles and machinery. The platform provides a centralized, role-based system allowing Admins, Sellers, Shippers, and Customers to interact seamlessly. It streamlines inventory management, order processing, real-time tracking, and communication across all stakeholders.

---

## 🚀 Features

### 1️⃣ **Multi-Role Access**

* **Admin:** Manage users, categories, monitor orders, generate reports.
* **Seller:** Add/manage products, update stock levels, process customer orders.
* **Customer:** Browse products, place orders, track deliveries, manage profiles.
* **Shipper:** Update order delivery status and manage assigned orders (future module).

### 2️⃣ **Core Functionalities**

* Secure registration with Aadhaar and photo verification.
* Role-based login and dashboard access.
* Inventory and product management for sellers.
* Real-time order tracking for customers.
* Admin panel with analytics and reporting.
* Responsive design for all devices.

---

## 🏗️ Tech Stack

### **Frontend:**

* React.js
* Axios for API requests
* React Router for navigation
* Responsive UI with HTML, CSS, JavaScript

### **Backend:**

* Java Spring Boot (Admin, Seller, Customer)
* MySQL database with JPA repositories
* RESTful APIs for communication
* BCrypt encryption for secure password storage

---

## 📂 Modules

### **Admin Module:**

* User Management (approve/reject sellers, monitor customers)
* Category Management
* Order Monitoring and History
* Sales Reports and Analytics

### **Seller Module:**

* Add, update, or remove products
* Manage stock availability in real-time
* Handle incoming customer orders

### **Customer Module:**

* Search/browse spare parts by category or vehicle
* Add to cart and place orders
* View and track order history
* Manage profile details

### **Authentication & Authorization:**

* Role-based access control
* Secure login sessions (future JWT implementation)
* Encrypted password storage

---

## 🗄️ Database Design

Main tables include:

* **Customer**: Stores user info with Aadhaar verification
* **Address**: Linked to customers for delivery details
* **Category**: Product categorization
* **Product**: Spare parts details with stock levels
* **Cart**: Temporary storage for user-selected products
* **Orders**: Tracks order status, assigned delivery, timestamps
* **Review**: Feedback and ratings from customers

---

## 🛠️ Requirements

### **Hardware:**

* Intel i3 or higher processor
* 8GB RAM (16GB recommended)
* 256GB SSD or 500GB HDD

### **Software:**

* Windows/Linux/macOS
* Node.js and npm
* Java JDK 17+
* MySQL database
* Apache Maven
* Git & GitHub
* Postman for API testing

---

## ✅ Installation & Setup

1. **Clone the Repository:**

```bash
git clone https://github.com/Prasad-R-Patil/Spare_Part_Wala.git
cd Spare_Part_Wala
```

2. **Backend Setup:**

* Import Spring Boot project into Eclipse or IntelliJ.
* Configure MySQL database credentials in `application.properties`.
* Run `mvn clean install`.
* Start the Spring Boot application.

3. **Frontend Setup:**

```bash
cd frontend-react
npm install
npm start
```

4. Access the application at: `http://localhost:3000`

---

## 🧪 Testing

* Manual test cases are included for registration, login, adding products, placing orders, cart functionality, and security validations.
* Tested for mobile responsiveness and SQL injection vulnerabilities.

---

## 📸 Screenshots

* Homepage
* Admin Dashboard
* Customer Registration/Login
* Seller Product Management
* Order Tracking

*(Refer to `/screenshots` folder for all UI captures)*

---

## 📜 References

* [ReactJS Documentation](https://reactjs.org)
* [Spring Boot Documentation](https://spring.io/projects/spring-boot)
* [MySQL Documentation](https://dev.mysql.com/doc/)
* [MDN Web Docs](https://developer.mozilla.org)
* [Stack Overflow](https://stackoverflow.com)

---

## 👥 Contributors

* **Prasad Ravindra Patil**
* Vikrant Pramod Kambli
* Sagar Ashok Mali
* Tejas Mahendra Jadhav

---

## 📄 License

This project is for educational purposes as part of PG Diploma in Advanced Computing. Future versions may adopt an open-source license.
