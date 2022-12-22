package com.solvd.university.classes;

public abstract class Person {
	private int personalId;
	private String name;
	private String lastName;
	private int age;
	private long phoneNumber;


	//---------Constructor---------

	public Person(String name, String lastName, int age, long phoneNumber){

		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.phoneNumber = (phoneNumber);

	}

    public Person() {

    }

	//------------Encapsulation-------------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
			this.phoneNumber = phoneNumber;
	}

}
