package classes;

import interfaces.IAllowPassengers;

public final class Transport implements IAllowPassengers { //buses assigned to the university

	private  String model;
	private int capacitySeats;
	private int quantityPassengers;

	public Transport(String model, int capacitySeats, int quantityPassengers) {

		this.model = model;
		this.capacitySeats = capacitySeats;
		this.quantityPassengers = quantityPassengers;
	}

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
				System.out.println("The bus start his ride");
			}else if (getQuantityPassengers() < getCapacitySeats()) {
				System.out.println("The bust is waiting for more passengers");
			}
	}

	public String toString() {

		return  "[Model bus= " + getModel() +" | "+ "Capacity Seats= " + getCapacitySeats() +" | "+
				"Quantity Of Passengers= " + getQuantityPassengers() + "]" + "\n";

	}

}
