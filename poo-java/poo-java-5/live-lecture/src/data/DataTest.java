package data;

import exception.DuplicatedCpfException;

public class DataTest {

    private static final ManageAccounts accounts = new ManageAccounts();
    private static final ManageClients clients = new ManageClients();

    public static ManageClients loadClients() {
        try {
            clients.addClient("12345678901", "Emma Watson");
            clients.addClient("12345678902", "Steven Spielberg");
            clients.addClient("12345678903", "Bruce Lee");
            clients.addClient("12345678904", "Walt Disney");
            clients.addClient("12345678905", "Morgan Freeman");
            clients.addClient("12345678906", "Lady Gaga");
            clients.addClient("12345678907", "Eddie Murphy");
            clients.addClient("12345678908", "Denzel Washington");
        } catch (DuplicatedCpfException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public static ManageAccounts loadAccounts() {
        accounts.addCurrentAccount(clients.getClient("12345678901"));
        accounts.addCurrentAccount(clients.getClient("12345678902"));
        accounts.addCurrentAccount(clients.getClient("12345678903"));
        accounts.addCurrentAccount(clients.getClient("12345678904"));
        accounts.addCurrentAccount(clients.getClient("12345678905"));
        accounts.addCurrentAccount(clients.getClient("12345678906"));
        accounts.addCurrentAccount(clients.getClient("12345678907"));
        accounts.addCurrentAccount(clients.getClient("12345678908"));
        return accounts;
    }

}
