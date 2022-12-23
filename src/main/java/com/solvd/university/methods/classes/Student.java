package com.solvd.university.methods.classes;

import com.solvd.university.exceptions.NegativeQuantityException;
import com.solvd.university.interfaces.IStudy;
import com.solvd.university.methods.RandomGenerate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;


public class Student extends Person implements IStudy {
	
	private int studentId; //{1234, 6789, 1011};
	private String grade; //{"A","B", "A-"}; // Quality Points per subject of the students
	private float gpa; // {4.0f, 3.0f, 3.67f }; //Grade Point Average
	private Subject subject;
	private Proffesor proffesor;
	private Classroom classroom;

	private static final Logger LOGGER = LogManager.getLogger(Student.class);

	//--------- Constructor  ----------
	public Student (int studentId, String grade, float gpa, String name, String lastName, int age, int phoneNumber,
					Subject subject, Proffesor proffesor, Classroom classroom)  {
		super(name, lastName, age, phoneNumber);

		try {
			if (age < 0){
				throw new NegativeQuantityException("The quantity isert is negative, must be positive");
			}
		}catch(NegativeQuantityException e) {
			LOGGER.error("The negative age doesn't exists, please isert a right value");
		}

		setStudentId(RandomGenerate.generateNumberRandom(1, 60000));
		this.grade = grade;
		this.gpa = gpa;
		this.subject = subject;
		this.proffesor = proffesor;
		this.classroom = classroom;
	}

	//---------- Encapsulation ------------

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Proffesor getProffesor() {
		return proffesor;
	}

	public void setProffesor(Proffesor proffesor) {
		this.proffesor = proffesor;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public int hashCode() {
		return Objects.hash(studentId, subject);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		if (obj.hashCode() != this.hashCode())
			return false;
		Student other = (Student) obj;
		return Objects.equals(studentId, other.studentId) && Objects.equals(subject, other.subject);
	}

	@Override
	public String toString() {
		return  "Full Name= " + getName() +" " +getLastName() +" | "+ "Age= "+ getAge() +" | "+
				"Phone Number= "+getPhoneNumber() +" - "+ "{Student ID= " + studentId +" "+
				"Grade= " + grade + " "+  "GPA= "+ gpa + "}" +"\n"+ subject +"\n"+ proffesor +"\n"+ classroom + "\n";
	}

	//----------Interface----------
	@Override
	public void study(){

		if (getGpa() >= 4.9f && getGpa() <=5){
			LOGGER.info("This student achieved the 'Summa Cum Laude' recognition ");
		}else if (getGpa() >= 4.70f && getGpa() <= 4.89f){
			LOGGER.info("This student achieved the 'Magna Cum Laude' recognition ");
		}else if (getGpa() >= 3.0f && getGpa() <= 4.69f) {
			LOGGER.info("Enabled to attend classes ");
		}else{
			LOGGER.info("This student don't fulfill with a minimum approval score ");
		}
	}


}
