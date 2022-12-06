package exceptions;

public class NegativeQuantityException extends Exception{

    public NegativeQuantityException(){


        super("The quantity must be positive");
    }
}
