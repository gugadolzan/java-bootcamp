package data;

import exception.DuplicatedCpfException;
import model.Client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManageClients {

    private final Map<String, Client> clients;

    public ManageClients() {
        clients = new HashMap<>();
    }

    public Client addClient(String cpf, String name) throws DuplicatedCpfException {
        if (clients.get(cpf) != null) {
            throw new DuplicatedCpfException("CPF already exists");
        }

        Client client = new Client(cpf, name);
        clients.put(cpf, client);
        return client;
    }

    public Client getClient(String cpf) {
        return clients.get(cpf);
    }

    public Client removeClient(String cpf) {
        return clients.remove(cpf);
    }

    public List<String> getAll() {
        return clients.values().stream()
                .map(Client::toString)
                .collect(Collectors.toList());
    }

}
