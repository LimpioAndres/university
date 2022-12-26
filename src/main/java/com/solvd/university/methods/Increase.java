package com.solvd.university.methods;

import com.solvd.university.classes.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Increase{

    public List<Float> calc(BiFunction<Float, Float, Float> bi, List<Employee> employeeList, Float increase){

        List <Float> salaryList = new ArrayList<>();

        employeeList.stream().forEach((iteratorEmployee) -> {
            salaryList.add(bi.apply(iteratorEmployee.getSalary(), increase));
        });
        return salaryList;
    }
}
