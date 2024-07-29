package javaminiproject;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

	Bank bank = new Bank();
    Scanner scanner = new Scanner(System.in);
    String accountNumber, accountHolderName, password;
    double amount;
    int choice;

    while (true) {
        System.out.println("\nBank Management System");
        System.out.println("1. Create Account");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();  
        switch (choice) {
            case 1:
                System.out.print("Enter account number: ");
                accountNumber = scanner.nextLine();
                System.out.print("Enter account holder name: ");
                accountHolderName = scanner.nextLine();
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                bank.createAccount(accountNumber, accountHolderName, password);
                break;
            case 2:
                System.out.print("Enter account number: ");
                accountNumber = scanner.nextLine();
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                Account account = bank.getAccount(accountNumber);
                if (account != null && account.checkPassword(password)) {
                    while (true) {
                        System.out.println("\nWelcome, " + account.getAccountHolderName());
                        System.out.println("1. Deposit");
                        System.out.println("2. Withdraw");
                        System.out.println("3. Check Balance");
                        System.out.println("4. Transfer");
                        System.out.println("5. Logout");
                        System.out.print("Enter your choice: ");
                        choice = scanner.nextInt();
                        scanner.nextLine();  // consume the newline

                        switch (choice) {
                            case 1:
                                System.out.print("Enter amount to deposit: ");
                                amount = scanner.nextDouble();
                                bank.deposit(accountNumber, amount);
                                break;
                            case 2:
                                System.out.print("Enter amount to withdraw: ");
                                amount = scanner.nextDouble();
                                bank.withdraw(accountNumber, amount);
                                break;
                            case 3:
                                bank.checkBalance(accountNumber);
                                break;
                            case 4:
                                System.out.print("Enter account number to transfer to: ");
                                String toAccountNumber = scanner.nextLine();
                                System.out.print("Enter amount to transfer: ");
                                amount = scanner.nextDouble();
                                bank.transfer(accountNumber, toAccountNumber, amount);
                                break;
                            case 5:
                                System.out.println("Logged out successfully.");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }
                        if (choice == 5) break;  // exit the inner while loop to logout
                    }
                } else {
                    System.out.println("Account not found or incorrect password. Please try again.");
                }
                break;
            case 3:
                System.out.println("Thank you for using the Bank Management System.");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
  }

	

}
