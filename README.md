# 🚗 Rex's Rent - Car Rental System

Welcome to **Rex's Rent**, an object-oriented programming project designed to manage a car rental system. This project includes various features such as customer management, car management, transactions, and business evaluation. Built using **Java**, this project leverages OOP concepts like inheritance, encapsulation, and polymorphism.

---

## 📂 Project Structure

The project has the following folder structure:

- **`src/`**: Contains the main source code.
  - **`Main.java`**: The application entry point. Provides the main menu for logging in as Admin or Employee.
  - **`Admin.java`**: Manages admin features, such as viewing transaction history, business evaluation, and car data management.
  - **`Pegawai.java`**: Manages employee features, such as adding customers, creating transactions, and returning cars.
  - **`Transaksi.java`**: Manages transaction data, including reading and writing data to CSV files.
  - **`Mobil.java`**: Manages car data, including availability status and rental prices.
  - **`Pelanggan.java`**: Manages customer data, including reading and writing data to CSV files.
  - **`Akun.java`**: Abstract class for Admin and Employee login.
- **`lib/`**: Folder for external dependencies (if any).
- **`bin/`**: Folder for compiled files.
- **`.vscode/`**: Configuration for Visual Studio Code.
- **`daftarmobil.csv`**: CSV file storing car data.
- **`daftarpelanggan.csv`**: CSV file storing customer data.
- **`transaksi.csv`**: CSV file storing transaction data.

---

## ✨ Key Features

### 🔑 Login

- **Admin**: Username: `admin`, Password: `admin123`
- **Employee**: Username: `pegawai`, Password: `12345`

### 👨‍💼 Admin

- **View Transaction History**: Displays all completed transactions.
- **Business Evaluation**: Shows total revenue from all transactions.
- **Car Management**: Add, edit, and manage car data.
- **Update Employee Login Data**: Change the username and password for employees.

### 👷 Employee

- **Add Customer Data**: Add new customers to the system.
- **Edit Customer Data**: Modify existing customer data.
- **View Customer Data**: Display the list of customers.
- **Add Transaction**: Create new transactions for customers.
- **Return Car**: Change the car status back to available.

### 📄 Data Management

- **Cars**: Car data is stored in `daftarmobil.csv`.
- **Customers**: Customer data is stored in `daftarpelanggan.csv`.
- **Transactions**: Transaction data is stored in `transaksi.csv`.

---

## 🛠️ Technologies Used

- **Programming Language**: Java
- **Paradigm**: Object-Oriented Programming (OOP)
- **File Handling**: Reading and writing data using CSV files.
- **IDE**: Visual Studio Code

---

## 🚀 How to Run

1. Ensure you have **Java Development Kit (JDK)** installed.
2. Clone this repository to your computer.
3. Open the project folder in **Visual Studio Code**.
4. Run the `Main.java` file to start the application.

---

## 📊 Sample Data

### Cars

| ID  | Model    | Brand | Rental Price | Status        |
| --- | -------- | ----- | ------------ | ------------- |
| M01 | 520i G30 | BMW   | Rp 2,500,000 | Not Available |
| M04 | Brio     | Honda | Rp 250,000   | Available     |

### Customers

| ID   | Name          | Phone Number | ID Number    | Address                  | Gender |
| ---- | ------------- | ------------ | ------------ | ------------------------ | ------ |
| P001 | Budi          | 08123456789  | 08123456789  | Jakarta                  | M      |
| P002 | Falih Elmanda | 081234567890 | 081234567890 | Jl. Tegal Parang Selatan | M      |

### Transactions

| Transaction ID | Date                | Employee | Customer | Car | Duration | Total Price  |
| -------------- | ------------------- | -------- | -------- | --- | -------- | ------------ |
| TRX0001        | 2025-04-13 10:52:58 | pegawai  | P001     | M04 | 4 Days   | Rp 1,000,000 |

---

## 📞 Contact

If you have any questions or suggestions, feel free to contact me via email: **[faliheghaisan@gmail.com](mailto:faliheghaisan@gmail.com)**.

---

Thank you for using **Rex's Rent**! 🚗✨
