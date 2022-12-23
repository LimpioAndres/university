package com.solvd.university.methods.classes;

public class Subject {
	
	private int idSubject; // {93092, 31467, 89105};
	private String nameSubject; // {"Investigation Methodology", "Operations Models", "Math IV"};
	private String descriptionSubject;
	private School school;

	//----------- Constructor ------------

	public Subject(int idSubject, String nameSubject, String descriptionSubject, School school) {

		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
		this.descriptionSubject = descriptionSubject;
		this.school = school;
	}

	//---------- Encapsulation ------------

	public Subject(int idSubject, String nameSubject){
		this.idSubject = idSubject;
		this.nameSubject = nameSubject;
	}

	public int getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(int idSubject) {
		this.idSubject = idSubject;
	}

	public String getNameSubject() {
		return nameSubject;
	}

	public void setNameSubject(String nameSubject) {
		this.nameSubject = nameSubject;
	}

	public String getDescriptionSubject() {
		return descriptionSubject;
	}

	public void setDescriptionSubject(String descriptionSubject) {
		this.descriptionSubject = descriptionSubject;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}


	public String toString() {

		return  "[Id Subject= " + getIdSubject() +" "+ " Subject Name= " + getNameSubject() + "]";

	}

}
