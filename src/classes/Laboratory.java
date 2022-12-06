package classes;

import interfaces.IEnable;

import java.time.LocalTime;

public class Laboratory extends Building implements IEnable {
	private short idLaboratory;
	private byte hours; // To organize a Schedule that includes the different subjects taking in this space
	private byte minutes; // To organize a Schedule that includes the different subjects taking in this space
	private Subject subject;

	public Laboratory(short idLaboratory, byte hours, byte minutes, Subject subject, String buildingsName, String floor) {

		super(buildingsName, floor);

		this.idLaboratory = idLaboratory;
		setHours(hours);
		setMinutes(minutes);
		this.subject = subject;
	}

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
		LocalTime doorClosed = LocalTime.of(19,01);

		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)){
			System.out.println("The Laboratories are opened");
		}else {
			System.out.println("The Laboratories are closed");
		}
	}
}
