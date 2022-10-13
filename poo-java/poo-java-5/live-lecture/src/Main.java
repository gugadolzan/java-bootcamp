import data.DataTest;
import data.ManageAccounts;
import data.ManageClients;
import exception.DuplicatedCpfException;
import exception.InvalidNumberException;
import exception.NonExistentAccountException;
import model.Client;
import util.Print;
import util.PrintOnPrinter;
import util.PrintOnScreen;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static ManageAccounts accounts = new ManageAccounts();
    private static ManageClients clients = new ManageClients();

    private static void handleClientMenuOption(int option) {
        String cpf, name;
        Client client;

        switch (option) {
            case 1:
                System.out.print("CPF: ");
                cpf = scanner.nextLine();
                System.out.print("Name: ");
                name = scanner.nextLine();

                try {
                    clients.addClient(cpf, name);
                } catch (DuplicatedCpfException e) {
                    System.out.println(e.getMessage());
                }
                break;

            case 2:
                System.out.print("CPF: ");
                cpf = scanner.nextLine();

                client = clients.getClient(cpf);

                if (client != null) {
                    System.out.println(client);
                } else {
                    System.out.println("Client not found");
                }
                break;

            case 3:
                System.out.print("CPF: ");
                cpf = scanner.nextLine();

                if (accounts.hasAccount(cpf)) {
                    System.out.println("It is necessary to delete the account of this client " +
                            "before deleting the client");
                    break;
                }

                client = clients.removeClient(cpf);
                if (client != null) {
                    System.out.println("Removed: " + client);
                } else {
                    System.out.println("Client not found");
                }
                break;

            case 4:
                System.out.println(clients.getAll());
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option");
                break;
        }

        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    private static void handleAccountMenuOption(int option) {
        double limit, value;
        int accountNumber, destinationAccountNumber;
        Client client;
        String cpf;

        switch (option) {
            case 1:
                System.out.print("CPF: ");
                cpf = scanner.nextLine();

                client = clients.getClient(cpf);
                if (client != null) {
                    accounts.addCurrentAccount(client);
                } else {
                    System.out.println("Client not found");
                }
                break;

            case 2:
                System.out.print("CPF: ");
                cpf = scanner.nextLine();

                client = clients.getClient(cpf);
                if (client != null) {
                    System.out.print("Limit: ");
                    limit = Double.parseDouble(scanner.nextLine());
                    accounts.addSpecialAccount(client, limit);
                } else {
                    System.out.println("Client not found");
                }
                break;

            case 3:
                System.out.print("CPF: ");
                cpf = scanner.nextLine();

                client = clients.getClient(cpf);
                if (client != null) {
                    accounts.addSavingsAccount(client);
                } else {
                    System.out.println("Client not found");
                }
                break;

            case 4:
                System.out.print("Account number: ");
                accountNumber = Integer.parseInt(scanner.nextLine());

                System.out.print("Value: ");
                value = Double.parseDouble(scanner.nextLine());

                try {
                    accounts.deposit(accountNumber, value);
                    System.out.println("Deposit successful");
                } catch (InvalidNumberException | NonExistentAccountException ex) {
                    System.out.println("Operation failed: " + ex.getMessage());
                }
                break;

            case 5:
                System.out.print("Account number: ");
                accountNumber = Integer.parseInt(scanner.nextLine());

                System.out.print("Value: ");
                value = Double.parseDouble(scanner.nextLine());

                try {
                    if (accounts.withdraw(accountNumber, value)) {
                        System.out.println("Withdraw successful");
                    } else {
                        System.out.println("Insufficient funds");
                    }
                } catch (InvalidNumberException | NonExistentAccountException ex) {
                    System.out.println("Operation failed: " + ex.getMessage());
                }
                break;

            case 6:
                System.out.print("Account number: ");
                accountNumber = Integer.parseInt(scanner.nextLine());

                try {
                    System.out.println(accounts.getAccount(accountNumber));
                } catch (NonExistentAccountException ex) {
                    System.out.println("Operation failed: " + ex.getMessage());
                }
                break;

            case 7:
                System.out.print("Account number: ");
                accountNumber = Integer.parseInt(scanner.nextLine());

                try {
                    accounts.removeAccount(accountNumber);
                    System.out.println("Account removed");
                } catch (NonExistentAccountException ex) {
                    System.out.println("Operation failed: " + ex.getMessage());
                }
                break;

            case 8:
                System.out.print("Account number: ");
                accountNumber = Integer.parseInt(scanner.nextLine());

                System.out.print("Destination account number: ");
                destinationAccountNumber = Integer.parseInt(scanner.nextLine());

                System.out.print("Value: ");
                value = Double.parseDouble(scanner.nextLine());

                try {
                    accounts.transfer(accountNumber, destinationAccountNumber, value);
                } catch (InvalidNumberException | NonExistentAccountException ex) {
                    System.out.println("Operation failed: " + ex.getMessage());
                }
                break;

            case 9:
                System.out.println("Screen or Printer? (S/P)");
                String input = scanner.nextLine();
                Print print;

                if (input.equalsIgnoreCase("S"))
                    print = new PrintOnScreen();
                else if (input.equalsIgnoreCase("P"))
                    print = new PrintOnPrinter();
                else {
                    System.out.println("Invalid option");
                    break;
                }

                print.print(accounts.getAllAccountsInfo().toString());
                break;

            case 10:
                System.out.println(accounts.getCurrentAccountsSortedByNumber());
                break;

            case 11:
                System.out.println(accounts.getCurrentAccountsSortedByBalance());
                break;

            case 12:
                System.out.println(accounts.getSpecialAccountsWithNegativeBalance());
                break;

            case 0:
                System.out.println("Finishing...");
                break;

            default:
                System.out.println("Invalid option");
                break;
        }

        System.out.println("Press enter to continue");
        scanner.nextLine();
    }

    public static void main(String[] args) {
        int mainMenuOption, accountMenuOption, clientMenuOption;

        clients = DataTest.loadClients();
        accounts = DataTest.loadAccounts();

        do {
            System.out.println("1. Client menu");
            System.out.println("2. Account menu");
            System.out.println("0. Exit");

            mainMenuOption = Integer.parseInt(scanner.nextLine());

            switch (mainMenuOption) {
                case 1:
                    System.out.println("1. Add client");
                    System.out.println("2. Get client info");
                    System.out.println("3. Remove client");
                    System.out.println("4. Get all clients info");
                    System.out.println("0. Back");

                    clientMenuOption = Integer.parseInt(scanner.nextLine());
                    handleClientMenuOption(clientMenuOption);

                    break;

                case 2:
                    System.out.println("1. Add current account");
                    System.out.println("2. Add savings account");
                    System.out.println("3. Add special account");
                    System.out.println("4. Deposit");
                    System.out.println("5. Withdraw");
                    System.out.println("6. Get balance");
                    System.out.println("7. Remove account");
                    System.out.println("8. Transfer");
                    System.out.println("9. Get all accounts info");
                    System.out.println("10. Get current accounts ordered by number");
                    System.out.println("11. Get current accounts ordered by balance");
                    System.out.println("12. Get special accounts with negative balance");
                    System.out.println("0. Back");

                    accountMenuOption = Integer.parseInt(scanner.nextLine());
                    handleAccountMenuOption(accountMenuOption);

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Invalid option");
                    break;

            }
        } while (mainMenuOption != 0);

        scanner.close();
    }

}
