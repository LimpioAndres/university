package classes;

import interfaces.IEnable;

import java.time.LocalTime;

public class DiningHall extends Building implements IEnable {
	private float profits;
	private float costs;
	private float investment;

	public DiningHall(float profits, float costs, float investment, String buildingsName, String floor){
		super(buildingsName, floor);
		this.profits = profits;
		this.costs = costs;
		setInvestment(investment);
	}
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
		if (investment >0) {
			this.investment = investment;
		}else{
			System.out.println("Please, insert a valid invest (must be up to zero");
		}
	}

	@Override
	public void open() {

		LocalTime timeNow = LocalTime.now();
		LocalTime initCook = LocalTime.of(8,59);
		LocalTime finishCook= LocalTime.of(12,00);

		LocalTime doorsOpened = LocalTime.of(11, 59);
		LocalTime doorClosed = LocalTime.of(15, 01);

		if (timeNow.isAfter(initCook) && timeNow.equals(finishCook));
			System.out.println("The lunch still cooking");


		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)) {
			System.out.println("Lunch ready ");
		} else {
			System.out.println("The Lunch done until tomorrow at the same time");
		}
	}
}
