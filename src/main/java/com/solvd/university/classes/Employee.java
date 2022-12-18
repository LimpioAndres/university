package com.solvd.university.classes;


import com.solvd.university.exceptions.NegativeQuantityException;
import com.solvd.university.exceptions.NoAssignedException;
import com.solvd.university.interfaces.IAttend;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


public class Employee extends Person implements IAttend {
	
	private int idEmployee;
	private String typeEmployee; //{"Full-time", "Part-time"};
	private String areaWorker; // {"Administration and Accounting", "Worker", "Security", "IT", "Control Studies", "Human Resources"};
	private String subareaWorker; //{"Dining", "Green Areas", "Mechanic", "Plumbing and Infraestructure", "classes.Library"};
	private String rangeEmployee; // {"Trainee", "Junior", "Mid", "Senior", "Lead", "Director"};
	private int seniority; // {5, 1, 3}; //age working at the university
	private float salary; // {5000f, 1500f, 2800f}; // Salaries in USD per month

	private static final Logger LOGGER = LogManager.getLogger(Employee.class);

	//----------- Constructor ----------

	Employee(int idEmployee, String typeEmployee, String areaWorker, String subareaWorker, String rangeEmployee,
			 int seniority, float salary, String name, String lastName, int age, int phoneNumber){

		super(name, lastName, age, phoneNumber);

		try {
			if (age < 0){
				throw new NegativeQuantityException("The quantity isert is negative, must be positive");
			}
		}catch(NegativeQuantityException e) {
			LOGGER.error("The negative age doesn't exists, please isert a right value");
		}

		this.idEmployee = idEmployee;
		this.typeEmployee = typeEmployee;
		this.areaWorker = areaWorker;
		this.subareaWorker = subareaWorker;
		this.rangeEmployee = rangeEmployee;
		this.seniority = seniority;
		this.salary = salary;
	}

	//---------- Encapsulation -----------

	public Employee() {
		super();
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getTypeEmployee() {
		return typeEmployee;
	}

	public void setTypeEmployee(String typeEmployee) {
		this.typeEmployee = typeEmployee;
	}

	public String getAreaWorker() {
		return areaWorker;
	}

	public void setAreaWorker(String areaWorker) {
		this.areaWorker = areaWorker;
	}

	public String getSubareaWorker() {
		return subareaWorker;
	}

	public void setSubareaWorker(String subareaWorker) {
		this.subareaWorker = subareaWorker;
	}


	public String getRangeEmployee() {
		return rangeEmployee;
	}

	public void setRangeEmployee(String rangeEmployee) {
		this.rangeEmployee = rangeEmployee;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {

		this.salary = salary;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idEmployee, areaWorker, subareaWorker,this.getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(idEmployee, other.idEmployee) && Objects.equals(areaWorker,other.areaWorker) &&
				Objects.equals(subareaWorker, other.subareaWorker) && getName().equals(other.getName());
	}

	@Override
	public void attend(){

		LocalDate dateActual = LocalDate.now();
		LocalTime actualTime = LocalTime.now();
		LocalTime maxTimeAttendance = LocalTime.of(07,00);
		boolean loop = false;
		int attendanceCheck;

		System.out.println(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(dateActual));
		System.out.println(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).format(actualTime));

		System.out.println("Please, mark your attendance with your id number: ");

		while (loop == false) {
			try {
				Scanner index = new Scanner(System.in);
				attendanceCheck = index.nextInt();

				if (attendanceCheck == idEmployee && actualTime.isBefore(maxTimeAttendance) || actualTime == maxTimeAttendance) {
					System.out.println("Welcome");
					loop = true;
				} else if (attendanceCheck == idEmployee && actualTime.isAfter(maxTimeAttendance)) {
					System.out.println("You are late");
					loop = true;
				} else {
					System.out.println("Please, mark a correct id number: ");
					loop = false;
				}
			} catch (InputMismatchException e) {
				loop = false;
				System.out.println("Please, mark a correct id number: ");
			}
		}
	}
}

