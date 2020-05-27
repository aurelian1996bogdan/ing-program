package exception;

public class NotEnoughFundsException extends BankException{

    int id;
    double balance;
    double amount;

    public NotEnoughFundsException(String message) {
        super(message);
    }

    public NotEnoughFundsException(int id, double balance, double amount, String message) {
        super(message);
        this.id = id;
        this.balance = balance;
        this.amount = Math.round(amount * 100) / 100d;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }

}
