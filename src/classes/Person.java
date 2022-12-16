package classes;

import exceptions.NegativeQuantityException;
import exceptions.PhoneNumberFormatException;

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
		setAge(age);
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
		try {
			if (age >= 0 || age <= 130) {
				this.age = age;
			} else if (age < 0){
				throw new NegativeQuantityException("The quantity isert is negative, must be positive");
			}else{
				System.out.println("Please, insert a valid age");
			}
		}catch(NegativeQuantityException e) {
			System.out.println("The negative age doesn't exists, please isert a right value");
		}
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) throws PhoneNumberFormatException {

		if (phoneNumber <= 9999999999L || phoneNumber >10000000000L){
			throw new PhoneNumberFormatException();
		}else {
			this.phoneNumber = phoneNumber;
		}
	}

}
