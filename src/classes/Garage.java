package classes;

import interfaces.IEnable;

import java.time.LocalTime;

public class Garage extends Building implements IEnable {
	
	private byte capacityBuses;
	private String routes;
	private Transport transport;

	public Garage(byte capacityBuses, String routes, Transport transport, String buildingsName, String floor) {

		super(buildingsName, floor);
		setCapacityBuses(capacityBuses);
		this.routes = routes;
		this.transport = transport;
	}

	public byte getCapacityBuses() {
		return capacityBuses;
	}

	public void setCapacityBuses(byte capacityBuses) {
		if(capacityBuses >0 || capacityBuses <=20) {
			this.capacityBuses = capacityBuses;
		}
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
			System.out.println(" Opened Garage, the buses can start their routes ");
		} else {
			System.out.println("Closed Garage");
		}
	}
}
