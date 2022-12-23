package com.solvd.university.methods.classes;

import com.solvd.university.exceptions.NullGameException;
import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public final class SportsArena extends Building implements IEnable {

	private static final Logger LOGGER = LogManager.getLogger(SportsArena.class);
	
	private String teams; //{"Crows", "Eagles", "Birds", "Visit"}
	private String sport_name; //{"Soccer", "Basketball", "Baseball"};
	private LocalDateTime date;

	//------------ Constructor -----------

	public SportsArena(String teams, String sport_name, LocalDateTime date, String buildingsName, String floor)
			throws NullGameException {
		super(buildingsName, floor);

		if (teams == "") {
			throw new NullGameException();
		}
		this.teams = teams;
		this.sport_name = sport_name;
		this.date = date;
	}

	//----------- Encapsulation -------------

	public String getTeams() {
		return teams;
	}

	public void setTeams(String teams) {
			this.teams = teams;

	}

	public String getSport_name() {
		return sport_name;
	}

	public void setSport_name(String sport_name) {
		this.sport_name = sport_name;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getDateFormated() {
		String format = "dd-MM-yyyy HH:mm:ss";
		DateTimeFormatter formater = DateTimeFormatter.ofPattern(format);
		return formater.format(this.date);
	}

	@Override
	public void open() {

		LocalTime timeNow = LocalTime.now();
		LocalTime doorsOpened = LocalTime.of(04, 59);
		LocalTime doorClosed = LocalTime.of(19, 01);

		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)) {
			LOGGER.info("The Sports Starts early");
		} else {
			LOGGER.info("Tomorrow is a new day to do new exercises");
		}
	}
}