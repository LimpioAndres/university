package com.solvd.university.classes;

public abstract class Building{

	//Classrooms are into buildings called "Module"
	private String buildingsName; /* {"Module 1", "Module 2", "Module 3", "Module 4",
			"Dining Hall", "Laboratories", "classes.Library", "classes.Garage of Buses", "Sports arena", "Security", "Administration",
			"Control Studies", "IT"};*/
	private String floor; //{"Ground level", 1st floor", "2nd floor", "3rd floor"};

	//----------Constructor---------

	public Building(String buildingsName, String floor) {

		this.buildingsName = buildingsName;
		this.floor = floor;
	}

	//--------- Encapsulation ---------

	public String getBuildingsName() {
		return buildingsName;
	}

	public void setBuildingsName(String buildingsName) {
		this.buildingsName = buildingsName;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {

		return  "Name of building= " + buildingsName + "\n" +
				"Number floor's = " + floor;
	}

}
