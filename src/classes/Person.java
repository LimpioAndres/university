package classes;

import java.util.Objects;

public abstract class Person {
	private int personalId;
	private String name;
	private String lastName;
	private int age;
	private long phoneNumber;

	public Person(String name, String lastName, int age, long phoneNumber){
		this.name = name;
		this.lastName = lastName;
		setAge(age);
		setPhoneNumber(phoneNumber);
	}
	public int getPersonalId() {
		return personalId;
	}

	public void setPersonalId(int personalId) {
		this.personalId = personalId;
	}

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
		if (age >=0 || age <= 130) {
			this.age = age;
		}else{
			System.out.println("Please, insert a valid age");
		}
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		if(phoneNumber <= 9999999999L || phoneNumber >10000000000L){
			this.phoneNumber = phoneNumber;
		}else{
			System.out.println("Please, insert a real phone number");
		}
	}


	@Override
	public String toString() {
		return name + " " + lastName + " " + age + " " + phoneNumber;
	}


}
