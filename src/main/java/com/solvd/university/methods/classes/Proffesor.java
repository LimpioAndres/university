package com.solvd.university.methods.classes;

import com.solvd.university.exceptions.NegativeQuantityException;
import com.solvd.university.interfaces.ITeach;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Objects;



public class Proffesor extends Employee implements ITeach {
	
	private int idProffesor;
	private Student student;
	private Subject subject;
	private School school;
	private Classroom classroom;

	private static final Logger LOGGER = LogManager.getLogger(Proffesor.class);

	Proffesor(int idProffesor, int idEmployee, String typeEmployee, String areaWorker, String subareaWorker,
			  String rangeEmployee, int seniority, float salary, String name, String lastName, int age, int phoneNumber ){

		super(idEmployee, typeEmployee, areaWorker, subareaWorker, rangeEmployee, seniority, salary, name,
				lastName, age, phoneNumber);

		try {
			if (age < 0){
				throw new NegativeQuantityException("The quantity isert is negative, must be positive");
			}
		}catch(NegativeQuantityException e) {
			LOGGER.error("The negative age doesn't exists, please isert a right value");
		}

		this.idProffesor = idProffesor;
		this.student = student;
		this.subject = subject;
		this.school = school;
		this.classroom = classroom;

	}

	public Proffesor(int idProffesor, String name, String lastName){
		super();
		setName(name);
		setLastName(lastName);
		this.idProffesor = idProffesor;
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

	@Override
	public String toString() {

		return  "[Id Proffesor= " + getIdProffesor() +" "+" Full Name= " + getName() +" " +getLastName() + "]";

	}

}


