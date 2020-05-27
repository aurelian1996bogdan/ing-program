package entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Customer {

    private String name;
    private Gender gender;
    private String phoneNumber;
    private String city;
    private Set<AbstractAcount> accounts = new HashSet<>();

    public Customer(String name, Gender gender, String phoneNumber, String city, Set<AbstractAcount> accounts) {
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.accounts = accounts;
    }

    public Customer(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public Customer(String name, Gender gender, Set<AbstractAcount> accounts) {
        this.name = name;
        this.gender = gender;
        this.accounts = accounts;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<AbstractAcount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<AbstractAcount> accounts) {
        this.accounts = accounts;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(name, customer.name) &&
                gender == customer.gender &&
                Objects.equals(phoneNumber, customer.phoneNumber) &&
                Objects.equals(city, customer.city) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, phoneNumber, city);
    }
}
