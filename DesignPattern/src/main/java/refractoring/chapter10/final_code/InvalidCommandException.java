package refractoring.chapter10.final_code;

public class InvalidCommandException extends Exception {
    public InvalidCommandException(String name) {
        super(name);
    }
    public InvalidCommandException() {
    }
}
