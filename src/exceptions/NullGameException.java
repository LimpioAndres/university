package exceptions;

public class NullGameException extends RuntimeException{

    public NullGameException(){

        super("No teams assigned");

    }
}
