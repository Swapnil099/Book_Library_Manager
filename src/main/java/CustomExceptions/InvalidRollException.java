package CustomExceptions;

public class InvalidRollException extends RuntimeException{
    public InvalidRollException(){
        super("Invalid Roll Number");
    }
}
