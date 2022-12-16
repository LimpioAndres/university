package classes;

import methods.ShowList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Main {

    public static void main(String[] args) {


        ArrayList<Campus> campus = new ArrayList<>();
        ArrayList<Student> student = new ArrayList<>();
        ArrayList<Subject> subject = new ArrayList<>();
        ArrayList<Proffesor> proffesor = new ArrayList<>();
        ArrayList<Classroom> classroom = new ArrayList<>();
        List<Transport> transport = new LinkedList<>();


        //Adding value to attributes in objects

        Classroom classroom1 = new Classroom(24, 10, 00, "Module 2", "Floor 3");
        Classroom classroom2 = new Classroom(13, 02, 00, "Module 1", "Floor 1");

        Subject subject1 = new Subject(198756, "Data Abstraction");
        Subject subject2 = new Subject(177891, "Electronic");

        Proffesor proffesor1 = new Proffesor(3465, "Alejandra", "Firmino");
        Proffesor proffesor2 = new Proffesor(7864, "Elizabeth", "Rios");


        campus.add(new Campus("Universidad de Oriente", "Monagas, Venezuela",
                "From people we come, to people us go", "Milena Bravo de Romero"));


        student.add(new Student(0, "A", 4.4F, "Andres", "Limpio",
                29, 1234567890, new Subject(189762, "Math IV"),
                new Proffesor(8274, "Jhon", "Smith"),
                new Classroom(16, 07, 00, "Module 1", "Floor 2")));
        student.add(new Student(0, "A+", 5.0F, "Jess", "Thame", 19,
                433457890, subject1, proffesor1, classroom1));
        student.add(new Student(0, "B", 3.9F, "Tim", "Thyf", 22,
                133453890, subject2, proffesor2, classroom2));

        transport.add(new Transport ("Mercedes Citaro 2020", 30, 19));
        transport.add(new Transport ("Mercedes Citaro E 2022", 60, 60));
        transport.add(new Transport ("Encava ENT610 2019", 56, 33));
        transport.add(2, new Transport ("Volvo 9800 2023", 56, 33));

        System.out.println("University details");
        ShowList.listDetailed(campus);
        System.out.println("Students details");
        ShowList.listDetailed(student);
        System.out.println("Transport details");
        ShowList.listDetailed(transport);

        for (Transport iterator:transport) {
            System.out.println("Passengers per buses= " + iterator.getModel());
        }
    }
}
