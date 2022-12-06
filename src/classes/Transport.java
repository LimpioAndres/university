package classes;

import interfaces.IAllowPassengers;

public final class Transport implements IAllowPassengers { //buses assigned to the university

	private String model; //{"Mercedes Citaro", "Mercedes Tourismo"}
	private byte capacitySeats; //{40, 50, 60}; //seats in each bus
	private byte quantityPassengers; //{30, 45, 57};

	public Transport(String model, byte capacitySeats, byte quantityPassengers) {

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

	public byte getCapacitySeats() {
		return capacitySeats;
	}

	public void setCapacitySeats(byte capacitySeats) {
		this.capacitySeats = capacitySeats;
	}

	public byte getQuantityPassengers() {
		return quantityPassengers;
	}

	public void setQuantityPassengers(byte quantityPassengers) {
		this.quantityPassengers = quantityPassengers;
	}

	@Override

	public void allow(){


			if (getQuantityPassengers() == getCapacitySeats()) {
				System.out.println("The bus start his ride");
			}else if (getQuantityPassengers() < getCapacitySeats() && getQuantityPassengers() >=0 && getQuantityPassengers() >= 0 ) {
				System.out.println("The bust is waiting for more passengers");
			}
	}



}
