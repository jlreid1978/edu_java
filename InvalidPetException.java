public class InvalidPetException extends RuntimeException {

    // Default constructor
    public InvalidPetException() {
        super("Your pet is invalid!");
    }

    
    public InvalidPetException(String s) {
        super(s);
    }
}
