package com.solvd.university.classes;

import com.solvd.university.exceptions.HourFormatException;
import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class Classroom extends Building implements IEnable {
	
	private int idClassroom; //number of classroom at the university
	private int hours; // To organize a Schedule that includes the different subjects taking in this space
	private int minutes; // To organize a Schedule that includes the different subjects taking in this space
	private Subject subject;

	private static final Logger LOGGER = LogManager.getLogger(Classroom.class);

	//--------- Constructor -----------

	public Classroom (int idClassroom, int hours, int minutes, String buildingsName, String floor)
			throws HourFormatException {

		super(buildingsName, floor);

		if(minutes < 0 || minutes > 60 || hours < 0 || hours > 23) {
			throw new HourFormatException();
		}
		this.idClassroom = idClassroom;
		this.hours = hours;
		this.minutes = minutes;
		this.subject = subject;
	}

	//------------ Encapsulation -----------
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
			this.hours = hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
			this.minutes = minutes;

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
