package com.solvd.university.classes;

import com.solvd.university.exceptions.HourFormatException;
import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class Laboratory extends Building implements IEnable {
	private short idLaboratory;
	private byte hours; // To organize a Schedule that includes the different subjects taking in this space
	private byte minutes; // To organize a Schedule that includes the different subjects taking in this space
	private Subject subject;

	private static final Logger LOGGER = LogManager.getLogger(Laboratory.class);

	//----------- Constructor -----------
	public Laboratory(short idLaboratory, byte hours, byte minutes, Subject subject, String buildingsName, String floor)
			throws HourFormatException {

		super(buildingsName, floor);

		if(minutes < 0 || minutes > 60 && hours < 0 || hours > 23) {
			throw new HourFormatException();
		}else{
			LOGGER.error("Insert a valid hour and minute");
		}

		this.idLaboratory = idLaboratory;
		this.hours = hours;
		this.minutes = minutes;
		this.subject = subject;
	}

	//----------- Encapsulation ------------
	public short getIdLaboratory() {
		return idLaboratory;
	}

	public void setIdLaboratory(short idLaboratory) {
		this.idLaboratory = idLaboratory;
	}

	public byte getHours() {
		return hours;
	}

	public void setHours(byte hours) {
			this.hours = hours;

	}

	public byte getMinutes() {
		return minutes;
	}

	public void setMinutes(byte minutes) {
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
		LocalTime doorClosed = LocalTime.of(19,01);

		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)){
			System.out.println("The Laboratories are opened");
		}else {
			System.out.println("The Laboratories are closed");
		}
	}
}
