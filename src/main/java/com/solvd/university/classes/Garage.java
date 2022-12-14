package com.solvd.university.classes;

import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public class Garage extends Building implements IEnable {

	private static final Logger LOGGER = LogManager.getLogger(Garage.class);
	private byte capacityBuses;
	private String routes;
	private Transport transport;

	//----------- Constructor ------------

	public Garage(byte capacityBuses, String routes, Transport transport, String buildingsName, String floor) {

		super(buildingsName, floor);

		this.capacityBuses = capacityBuses;
		this.routes = routes;
		this.transport = transport;
	}

	//----------- Encapsulation -----------

	public byte getCapacityBuses() {
		return capacityBuses;
	}

	public void setCapacityBuses(byte capacityBuses) {

			this.capacityBuses = capacityBuses;

	}

	public String getRoutes() {
		return routes;
	}

	public void setRoutes(String routes) {
		this.routes = routes;
	}

	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	@Override
	public void open() {

		LocalTime timeNow = LocalTime.now();
		LocalTime doorsOpened = LocalTime.of(05, 59);
		LocalTime doorClosed = LocalTime.of(20, 01);

		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)) {
			LOGGER.info(" Opened Garage, the buses can start their routes ");
		} else {
			LOGGER.info("Closed Garage");
		}
	}
}
