package classes;

import interfaces.IEnable;

import java.time.LocalTime;

public class Classroom extends Building implements IEnable {
	
	private int idClassroom; //number of classroom at the university
	private int hours; // To organize a Schedule that includes the different subjects taking in this space
	private int minutes; // To organize a Schedule that includes the different subjects taking in this space
	private Subject subject;

	public Classroom (int idClassroom, int hours, int minutes, String buildingsName, String floor){

		super(buildingsName, floor);

		this.idClassroom = idClassroom;
		setHours(hours);
		setMinutes(minutes);
		this.subject = subject;
	}

	public int getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(int idClassroom) {
		this.idClassroom = idClassroom;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		if(hours >=00 || hours <=23) {
			this.hours = hours;
		}else{
			System.out.println("Insert a valid hour");
		}
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		if(minutes >=0 || minutes <=60) {
			this.minutes = minutes;
		}else{
			System.out.println("Insert a valid minute");
		}
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void open(){

		LocalTime timeNow = LocalTime.now();
		LocalTime doorsOpened = LocalTime.of(06,59);
		LocalTime doorClosed = LocalTime.of(18,01);

		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)){
			System.out.println("The Classrooms are opened for classes");
		}else {
			System.out.println("The Classrooms are closed");
		}
	}
}
