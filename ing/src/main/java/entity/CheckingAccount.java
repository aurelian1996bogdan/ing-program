package entity;

import java.util.Objects;

public class CheckingAccount extends AbstractAcount {

    public double overdraft;
    public Currency currency;

    public CheckingAccount(int id, double amount, double overdraft) {
        super(id,  amount);
        if (overdraft < 0) {
            throw new IllegalArgumentException("Cannot create an account with a starting negative overdraft");
        }
        this.overdraft = overdraft;
    }

    public CheckingAccount(int id, double amount, double overdraft, Currency currency) {
        super(id,  amount);
        if (overdraft < 0) {
            throw new IllegalArgumentException("Cannot create an account with a starting negative overdraft");
        }
        this.overdraft = overdraft;
        this.currency = currency;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CheckingAccount that = (CheckingAccount) o;
        return Double.compare(that.overdraft, overdraft) == 0 &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), overdraft, currency);
    }
}
