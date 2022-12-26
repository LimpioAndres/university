package com.solvd.university.enums;

public enum SubAreaWork {
    DINI ("Dining Hall"), ACC ("Accountant"), WORK1("Green Areas"),
    WORK2("Plumbing and Infrastructure"), LIBR ("Library"), MECH ("Mechanic"),
    ENG ("Engineering"), SOC ("SOCIALS"), SCIEN ("Science");
    private final String subArea;

     SubAreaWork(String subArea){
        this.subArea = subArea;
    }

    public String getSubArea(){
        return subArea;
    }

    @Override
    public String toString() {
        return  subArea;
    }
}
