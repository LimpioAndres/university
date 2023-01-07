package com.solvd.university.classes;

import com.solvd.university.exceptions.NullGameException;
import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public final class SportsArena extends Building implements IEnable {

	private static final Logger LOGGER = LogManager.getLogger(SportsArena.class);
	
	private String teams; //{"Crows", "Eagles", "Birds", "Visit"}
	private String sport_name; //{"Soccer", "Basketball", "Baseball"};

	//------------ Constructor -----------

	public SportsArena(String teams, String sport_name, String buildingsName, String floor)
			throws NullGameException {
		super(buildingsName, floor);

		if (teams == "") {
			throw new NullGameException();
		}
		this.teams = teams;
		this.sport_name = sport_name;
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