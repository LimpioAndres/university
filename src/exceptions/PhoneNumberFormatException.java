package exceptions;

public class PhoneNumberFormatException extends Exception{

    public PhoneNumberFormatException(){
            super("Incorrect insertion of a real phone number");
    }
}
