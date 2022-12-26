package com.solvd.university.enums;

public enum AreaWork {
    ADMIN ("Administration and Accounting"),
    PROFF ("Proffesor"), CTRS ("Control Studies"),
    HHRR ("Human Resources"),  WORK ("Worker"),
    IT ("IT"), SECU("Security");

    private final String area;

    AreaWork(String area){
        this.area = area;
    }

    public String getArea(){
        return area;
    }

    @Override
    public String toString() {
        return  area;
    }
}
