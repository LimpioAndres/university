package classes;

import interfaces.IEnable;

import java.time.LocalTime;

public class Classroom extends Building implements IEnable {
	
	private short idClassroom; //number of classroom at the university
	private byte hours; // To organize a Schedule that includes the different subjects taking in this space
	private byte minutes; // To organize a Schedule that includes the different subjects taking in this space
	private Subject subject;

	public Classroom (short idClassroom, byte hours, byte minutes, String buildingsName, String floor){
		super(buildingsName, floor);
		this.idClassroom = idClassroom;
		setHours(hours);
		setMinutes(minutes);
		this.subject = subject;
	}

	public short getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(short idClassroom) {
		this.idClassroom = idClassroom;
	}

	public byte getHours() {
		return hours;
	}

	public void setHours(byte hours) {
		if(hours >=00 || hours <=23) {
			this.hours = hours;
		}else{
			System.out.println("Insert a valid hour");
		}
	}

	public byte getMinutes() {
		return minutes;
	}

	public void setMinutes(byte minutes) {
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
