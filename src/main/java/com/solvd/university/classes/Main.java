package com.solvd.university.classes;

import com.solvd.university.enums.*;
import com.solvd.university.exceptions.HourFormatException;
import com.solvd.university.exceptions.NullGameException;
import com.solvd.university.methods.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws HourFormatException, NullGameException {

        ArrayList<Campus> campus = new ArrayList<>();
        ArrayList<Student> student = new ArrayList<>();
        ArrayList<Subject> subject = new ArrayList<>();
        ArrayList<Proffesor> proffesor = new ArrayList<>();
        ArrayList<Classroom> classroom = new ArrayList<>();
        ArrayList<Transport> transport = new ArrayList<>();
        ArrayList<School> school = new ArrayList<>();



        //Adding value to attributes in objects

        Classroom classroom1 = new Classroom(24, 10, 00, "Module 2", "Floor 3");
        Classroom classroom2 = new Classroom(13, 02, 00, "Module 1", "Floor 1");

        Subject subject1 = new Subject(198756, "Data Abstraction");
        Subject subject2 = new Subject(177891, "Electronic");

        Proffesor proffesor1 = new Proffesor(3465,"Jhon", "Smith");
        Proffesor proffesor2 = new Proffesor(7864, "Elizabeth", "Rios");

        campus.add(new Campus("Universidad de Oriente", "Monagas, Venezuela",
                "From people we come, to people us go", "Milena Bravo de Romero"));
        LOGGER.log(Level.INFO, "\n" + "University details" + "\n");
        ShowList.listDetailed(campus);


        student.add(new Student(0, "A", 4.7F, "Andres", "Limpio",
                29, 1234567890, new Subject(189762, "Math IV"),
                new Proffesor(8274, 0, TypeEmployee.FULL, AreaWork.PROFF, SubAreaWork.SCIEN,
                        "Senior", 10, 5000, "Josh", "Pecker",
                        48, 1238765489),
                new Classroom(16, 07, 00, "Module 1", "Floor 2")));
        student.add(new Student(0, "A+", 4.9F, "Jess", "Thame", 19,
                433457890, subject1, proffesor1, classroom1));
        student.add(new Student(0, "B", 3.9F, "Tim", "Thyf", 22,
                133453890, subject1, proffesor2, classroom2));
        LOGGER.info("Students details" + "\n");
        ShowList.listDetailed(student);

        LOGGER.info("Students status");
        for (Student iterators:student) {
            LOGGER.info("Student full name= " + iterators.getName() + " " + iterators.getLastName());
            iterators.study();
        }
        LOGGER.info("\n");

        transport.add(new Transport ("Mercedes Citaro 2020", 30, 19));
        transport.add(new Transport ("Mercedes Citaro E 2022", 60, 60));
        transport.add(new Transport ("Encava ENT610 2019", 56, 33));
        transport.add(2, new Transport ("Volvo 9800 2023", 56, 39));
        LOGGER.info("Transport details" + "\n");
        ShowList.listDetailed(transport);

        transport.stream().forEach((iterator1) -> {
            LOGGER.info("Passengers per buses= " + iterator1.getQuantityPassengers());
        });
        List<SportsArena> sportsArenas = Arrays.asList(
                new SportsArena("Bulls", "Soccer", "Gym 2020", "Ground"),
            new SportsArena("Tigers", "Basketball", "Gym 2020", "Ground"),
            new SportsArena("Parrots", "Baseball", "Arena 20", "Ground"),
            new SportsArena("Cats", "Soccer", "Gym 2020", "Ground"),
            new SportsArena("Builders", "Baseball", "Arena 20", "Ground"));

        LOGGER.info("\n");
        sportsArenas.stream().forEach((iterator2) -> {
            LOGGER.info("Teams names and sport= " + iterator2.getTeams() +" | "+ iterator2.getSport_name());
        });
        LOGGER.info("\n");

        school.add(new School(NameSchool.ENGI, AreaStudy.SYS, subject1, "Engineering Builder", "2"));
        school.add(new School(NameSchool.SCAP, AreaStudy.PET, new Subject(229762, "Math IV"),
                "Sciences Builder", "1"));
        school.add(new School(NameSchool.ADMI, AreaStudy.HHRR, new Subject(329261, "Stadistics"),
                "Engineering Builder", "2"));
        school.add(new School(NameSchool.ENGI, AreaStudy.PET, new Subject(158861, "Thermodynamic"),
                "Engineering Builder", "1"));

        List<Employee> employees = Arrays.asList(
                new Employee("Jimena", "Gomez", 4000),
                new Employee("Ruth", "Gamble", 8000),
                new Employee("Marco", "Diu", 1200)
        );
        //A simple program with Function
        /*Function<Integer, String> convert = x -> Integer.toString(x);
            LOGGER.info(convert.apply(50).length() + "\n");*/

        List<Object> nameSchool = getSchoolData(school, x -> x.getName());
        LOGGER.info("Name of schools: ");
        nameSchool.stream().forEach((iterator4) ->{
            LOGGER.info("The name of schools are: " + iterator4);
        });
        LOGGER.info("\n");

        Increase inc = new Increase();

        List<Float> salaries = inc.calc((salary, increase) ->
                salary + (salary * (increase/100)), employees, 25.0f);

        salaries.stream().forEach((iterator5) -> {
            LOGGER.info(iterator5);
        });

        Evaluator ev = new Evaluator();
        LOGGER.info("\n"+"Teams of Soccer");

        List<SportsArena> soccerTeams = ev.evaluate(
                sportsArenas, iteratorSports -> iteratorSports.getSport_name() == "Soccer");

        soccerTeams.stream().forEach((iterator6) -> {
            LOGGER.info(iterator6.getTeams());
        });

        Operation op = new Operation();
        Consumer<Student> cStudent1 = e -> LOGGER.info("Name: " + e.getName() + "GPA: " + e.getGpa());
        LOGGER.info("Student without gpa updated: ");
        op.acept(student,cStudent1);
        Consumer <Student>cStudent2 = e -> e.setGpa(e.getGpa()*1.02f);
        Consumer<Student> cStudent3 = cStudent2.andThen(cStudent1);
        LOGGER.info("Student with gpa updated: ");
        op.acept(student,cStudent3);

    }

    //Lambda Functions
    public static List<Object> getSchoolData
            (List<School> listSchool, Function<School, Object> func){

            List<Object> dataList = new ArrayList<>();

            listSchool.stream().forEach((iterator3) ->{
                dataList.add(func.apply(iterator3));
            });
        return dataList;
    }

}


