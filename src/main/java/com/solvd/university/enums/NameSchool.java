package com.solvd.university.enums;

public enum NameSchool {

    ENGI("Engineering"), SOC ("Social"), SPO ("Sport"),
    SCAP("Science Applied"), ADMI ("Administrative");
    private final String school;

    NameSchool(String school){
        this.school = school;
    }

    public String getSchool(){
        return school;
    }

    @Override
    public String toString() {
        return school;
    }
}
