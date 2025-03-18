# ATM Machine Project (Java OOP)

## Overview

This project is a simulation of an ATM (Automated Teller Machine) built using Java and Object-Oriented Programming (OOP) principles.  It provides a basic set of functionalities such as checking balance, depositing funds, withdrawing funds, and viewing transaction history.

## Features

*   **Account Management:**
    *   Create new user accounts.
    *   Authenticate users using account number and PIN.
*   **Transaction Processing:**
    *   **Check Balance:** View the current balance of the account.
    *   **Deposit Funds:** Deposit money into the account.
    *   **Withdraw Funds:** Withdraw money from the account (subject to sufficient balance).
    *   **Transaction History:**  View a record of recent transactions.
*   **Error Handling:**  Robust error handling to prevent invalid inputs and ensure data integrity.
*   **OOP Design:**  Demonstrates good OOP practices, including:
    *   **Encapsulation:** Data is protected within classes, accessed only through methods.
    *   **Abstraction:** Complex functionalities are simplified for the user.
    *   **Inheritance (Optional):** Can be extended to support different account types (e.g., Savings, Checking).
    *   **Polymorphism (Optional):**  Can be implemented using interfaces for different transaction types.
*   **Data Persistence (Optional):** Can be extended to save account data to a file or database.

## Technologies Used

*   **Java:** Programming language.
*   **Object-Oriented Programming (OOP):** Design paradigm.
*   **[Optional] File I/O:** For data persistence (saving and loading account data).
*   **[Optional] Database (e.g., MySQL, PostgreSQL, H2):** For more robust data persistence.

## Project Structure


ATM_Machine/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── atm/
│ │ │ │ ├── Account.java (Account class: balance, PIN, transaction history)
│ │ │ │ ├── ATM.java (Main ATM class: handles user interaction and transactions)
│ │ │ │ ├── Transaction.java (Represents a single transaction)
│ │ │ │ ├── Deposit.java (Class for deposit transaction - if using separate transaction classes)
│ │ │ │ ├── Withdrawal.java (Class for withdrawal transaction - if using separate transaction classes)
│ │ │ │ ├── Authentication.java (Handles user login and authentication)
│ │ │ │ ├── [Optional] SavingsAccount.java (Example of inheritance)
│ │ │ │ ├── [Optional] CheckingAccount.java (Example of inheritance)
│ │ │ │ ├── Main.java (Entry point for the program)
│ ├── test/ (JUnit test cases - recommended for testing critical functionalities)
│ │ ├── java/
│ │ │ ├── atm/
│ │ │ │ ├── AccountTest.java
│ │ │ │ ├── ATMTest.java
├── README.md (This file)
├── [Optional] pom.xml (If using Maven)
├── [Optional] build.gradle (If using Gradle)

## Getting Started

### Prerequisites

*   **Java Development Kit (JDK):**  Ensure you have a compatible JDK installed (version 8 or higher is recommended).  Download from [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.java.net/).
*   **[Optional] IDE (Integrated Development Environment):**  Recommended for ease of development (e.g., IntelliJ IDEA, Eclipse, NetBeans).
*   **[Optional] Build Tool (Maven or Gradle):**  If using a build tool, ensure it's installed correctly.

### Installation

1.  **Clone the repository:**

    ```bash
    git clone <repository_url>
    cd ATM_Machine
    ```

2.  **Compile and Run (using command line):**

    ```bash
    # Navigate to the src/main/java directory
    cd src/main/java
    # Compile the Java files
    javac atm/*.java
    # Run the program (from the src/main/java directory)
    java atm.Main
    ```

3.  **[Optional] Compile and Run (using IDE):**

    *   Import the project into your IDE.
    *   Configure the `Main.java` file as the entry point.
    *   Build and run the project.

4. **[Optional] Build and Run (using Maven/Gradle):**

    *   **Maven:**
        ```bash
        mvn clean install
        java -jar target/<your-jar-name>.jar
        ```

    *   **Gradle:**
        ```bash
        gradle clean build
        java -jar build/libs/<your-jar-name>.jar
        ```

## Usage

1.  **Run the program.**  The ATM will prompt you to enter your account number and PIN.
2.  **Follow the on-screen instructions.**  You will be able to choose from options like:
    *   Check Balance
    *   Deposit Funds
    *   Withdraw Funds
    *   View Transaction History
    *   Exit

## Code Examples

Here are some examples of how key functionalities might be implemented:

**Account.java (Example)**

```java
public class Account {
    private String accountNumber;
    private String pin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String accountNumber, String pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(String pin) {
        return this.pin.equals(pin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Transaction("Deposit", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Transaction("Withdrawal", amount, balance));
            return true;
        } else {
            return false; // Insufficient funds
        }
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }
}
IGNORE_WHEN_COPYING_START
content_copy
download
Use code with caution.
IGNORE_WHEN_COPYING_END

ATM.java (Example - Simplified)

import java.util.Scanner;

public class ATM {
    private Account currentAccount;

    public ATM(Account account) {
        this.currentAccount = account;
    }

    public void displayMenu() {
        System.out.println("\nWelcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. View Transaction History");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public void processOption(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Your balance is: $" + currentAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter amount to deposit: $");
                double depositAmount = scanner.nextDouble();
                currentAccount.deposit(depositAmount);
                System.out.println("Deposit successful.");
                break;
            // ... (other cases for withdraw, transaction history, exit)
            default:
                System.out.println("Invalid choice.");
        }
    }
}
IGNORE_WHEN_COPYING_START
content_copy
download
Use code with caution.
Java
IGNORE_WHEN_COPYING_END
Testing

[Recommended] Implement JUnit tests to ensure the correctness of your code. Focus on testing core functionalities such as:

Account creation and PIN validation

Deposit and withdrawal operations

Balance calculations

Transaction history tracking

Example (AccountTest.java):

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Test
    void testDeposit() {
        Account account = new Account("12345", "1234", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());
    }

    @Test
    void testWithdrawSufficientFunds() {
        Account account = new Account("12345", "1234", 100.0);
        assertTrue(account.withdraw(50.0));
        assertEquals(50.0, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Account account = new Account("12345", "1234", 100.0);
        assertFalse(account.withdraw(150.0));
        assertEquals(100.0, account.getBalance()); // Balance should not change
    }
}
IGNORE_WHEN_COPYING_START
content_copy
download
Use code with caution.
Java
IGNORE_WHEN_COPYING_END
Future Enhancements

GUI Interface: Implement a graphical user interface (GUI) using Java Swing or JavaFX.

Database Integration: Store account data in a database for persistent storage and scalability.

Multiple Account Types: Support different account types (e.g., Savings, Checking) using inheritance.

Transaction Fees: Implement transaction fees for certain operations.

Security Enhancements: Implement more robust security measures to protect user data.

Concurrency Handling: Implement thread-safe code to handle multiple users accessing the ATM simultaneously.

Reporting: Generate reports of transaction data.

Admin Panel: Create an admin panel to manage accounts and system settings.

Contributing

Contributions are welcome! Please feel free to submit pull requests to improve the project.

License

[Choose a license, e.g., MIT License]

MIT License

Copyright (c) [2025] [Neha]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
IGNORE_WHEN_COPYING_START
content_copy
download
Use code with caution.
IGNORE_WHEN_COPYING_END
