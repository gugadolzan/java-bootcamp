package model;

public class Client {

    private final String cpf;
    private final String name;

    public Client(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + cpf + ")";
    }

}
