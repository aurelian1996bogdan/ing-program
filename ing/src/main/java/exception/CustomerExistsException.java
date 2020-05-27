package exception;

public class CustomerExistsException extends BankException {

    public CustomerExistsException(String message) {
        super(message);
    }
}
