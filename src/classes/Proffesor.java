package classes;

import interfaces.ITeach;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class Proffesor extends Employee implements ITeach {
	
	private int idProffesor; // {979698, 899594, 010203};
	private Student student;
	private Subject subject;
	private School school;
	private Classroom classroom;

	Proffesor(int idProffesor, int idEmployee, String typeEmployee, String areaWorker, String subareaWorker,
			  String rangeEmployee, int seniority, float salary, String name, String lastName, int age, int phoneNumber ){

		super(idEmployee, typeEmployee, areaWorker, subareaWorker, rangeEmployee, seniority, salary, name,
				lastName, age, phoneNumber);

		this.idProffesor = idProffesor;
		this.student = student;
		this.subject = subject;
		this.school = school;
		this.classroom = classroom;
	}
	public int getIdProffesor() {
		return idProffesor;
	}
	public void setIdProffesor(int idProffesor) {
		this.idProffesor = idProffesor;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(idProffesor, school);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Proffesor))
			return false;
		Proffesor other = (Proffesor) obj;
		return Objects.equals(idProffesor, other.idProffesor) && Objects.equals(school, other.school);
	}


	@Override
	public void teach(){

		System.out.println("The students: " + getStudent().getName()
				+ "attend to the classroom: " + getClassroom().getIdClassroom() + "in subject: " +
				getSubject().getNameSubject());

	}

}


