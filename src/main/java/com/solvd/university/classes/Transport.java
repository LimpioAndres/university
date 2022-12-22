package com.solvd.university.classes;

import com.solvd.university.interfaces.IAllowPassengers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Transport implements IAllowPassengers { //buses assigned to the university

	private static final Logger LOGGER = LogManager.getLogger(Transport.class);

	private  String model;
	private int capacitySeats;
	private int quantityPassengers;

	//------------ Constructor -------------

	public Transport(String model, int capacitySeats, int quantityPassengers) {

		this.model = model;
		this.capacitySeats = capacitySeats;
		this.quantityPassengers = quantityPassengers;
	}

	//------------- Encapsulation ----------------

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacitySeats() {
		return capacitySeats;
	}

	public void setCapacitySeats(int capacitySeats) {
		this.capacitySeats = capacitySeats;
	}

	public int getQuantityPassengers() {
		return quantityPassengers;
	}

	public void setQuantityPassengers(int quantityPassengers) {
		this.quantityPassengers = quantityPassengers;
	}

	@Override

	public void allow(){


			if (getQuantityPassengers() == getCapacitySeats()) {
				LOGGER.info("The bus start his ride");
			}else if (getQuantityPassengers() < getCapacitySeats()) {
				LOGGER.info("The bust is waiting for more passengers");
			}
	}

	public String toString() {

		return  "[Model bus= " + getModel() +" | "+ "Capacity Seats= " + getCapacitySeats() +" | "+
				"Quantity Of Passengers= " + getQuantityPassengers() + "]" + "\n";

	}

}
