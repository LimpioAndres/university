package com.solvd.university.classes;

import com.solvd.university.exceptions.NegativeQuantityException;
import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class DiningHall extends Building implements IEnable {
	private float profits;
	private float costs;
	private float investment;

	private static final Logger LOGGER = LogManager.getLogger(DiningHall.class);

	//---------- Constructor -----------

	public DiningHall(float profits, float costs, float investment, String buildingsName, String floor){
		super(buildingsName, floor);

		try {
			if (investment < 0){
				throw new NegativeQuantityException("The quantity isert is negative, must be positive");
			}
		}catch(NegativeQuantityException e) {
			LOGGER.error("Please isert a right value (the investment must be positive");
		}
		this.profits = profits;
		this.costs = costs;
		this.investment = investment;
	}

	//------------ Encapsulation -----------
	public float getProfits() {
		return profits;
	}

	public void setProfits(float profits) {
		this.profits = profits;
	}

	public float getCosts() {
		return costs;
	}

	public void setCosts(float costs) {
		this.costs = costs;
	}

	public float getInvestment() {
		return investment;
	}

	public void setInvestment(float investment) {

			this.investment = investment;

	}

	@Override
	public void open() {

		LocalTime timeNow = LocalTime.now();
		LocalTime initCook = LocalTime.of(8,59);
		LocalTime finishCook= LocalTime.of(12,00);

		LocalTime doorsOpened = LocalTime.of(11, 59);
		LocalTime doorClosed = LocalTime.of(15, 01);

		if (timeNow.isAfter(initCook) && timeNow.equals(finishCook));
			LOGGER.info("The lunch still cooking");


		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)) {
			LOGGER.info("Lunch ready ");
		} else {
			LOGGER.info("The Lunch done until tomorrow at the same time");
		}
	}
}
