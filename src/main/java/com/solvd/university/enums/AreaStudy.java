package com.solvd.university.enums;

public enum AreaStudy {
    SYS("Systems Engineering"), PET("Petroleum"), ADM ("Administration"),
    ACC("Accounting"), HHRR ("Human Resources"), FTEC("Food Technology");
    private final String areaS;

    AreaStudy(String areaS){
        this.areaS = areaS;
    }

    public String getAreaS(){
        return areaS;
    }

    @Override
    public String toString() {
        return areaS;
    }
}
