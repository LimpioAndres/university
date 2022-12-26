package com.solvd.university.methods;

import com.solvd.university.classes.Student;

import java.util.List;
import java.util.function.Consumer;

public class Operation {

    public void acept (List<Student> students, Consumer<Student> cons) {
        students.stream().forEach((iteratorStudent) -> {
            cons.accept(iteratorStudent);
        });
    }
}
