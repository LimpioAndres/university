package com.solvd.university.exceptions;

public class NullGameException extends Exception{

    public NullGameException(){

        super("No teams assigned");

    }
}
