package com.solvd.university.enums;

public enum TypeEmployee {
    FULL("Full-Time"),
    PART ("Part-time"),
    PRAC ("Practice"),
    CONT ("Contract");

    private final String type;

    TypeEmployee(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    @Override
    public String toString() {
        return type;
    }



}
