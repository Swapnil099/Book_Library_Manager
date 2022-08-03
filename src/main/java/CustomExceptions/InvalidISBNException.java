package CustomExceptions;

public class InvalidISBNException extends RuntimeException{
    public InvalidISBNException(){
        super("Invalid ISBN Number");
    }
}
