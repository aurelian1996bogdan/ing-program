package entity;

import ch.qos.logback.core.net.server.Client;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Bank {

    private Set<Customer> clients ;
    private String code;
    private String address;

    public Bank() {
        this.clients = new HashSet<>();
    }

    public Bank(Set<Customer> clients) {
        this.clients = clients;
    }

    public Bank(Set<Customer> clients, String code, String address) {
        this.clients = clients;
        this.code = code;
        this.address = address;
    }

    public Set<Customer> getClients() {
        return clients;
    }

    public void setClients(Set<Customer> clients) {
        this.clients = clients;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addClient(Customer client) {
        this.clients.add(client);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(code, bank.code) &&
                Objects.equals(address, bank.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, address);
    }
}
