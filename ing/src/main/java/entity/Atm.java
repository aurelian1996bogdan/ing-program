package entity;

import javax.persistence.Entity;

@Entity
public class Atm {

    private Bank bank;
    private String location;
    private String managedBy;

    public Atm(Bank bank, String location, String managedBy) {
        this.bank = bank;
        this.location = location;
        this.managedBy = managedBy;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(String managedBy) {
        this.managedBy = managedBy;
    }
}
