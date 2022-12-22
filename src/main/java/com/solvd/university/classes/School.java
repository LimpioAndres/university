package com.solvd.university.classes;

import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class School extends Building implements IEnable {

	private static final Logger LOGGER = LogManager.getLogger(School.class);

	private String name; //{"Engineering", "Social", "Sports", "Science Applied", "Administrative"};
	private String areaStudy; /*{"Systems Engineering", "Petroleum", "Administration", "Accounting",
	"Human Resources", "Food technology"}; */
	private Subject subject;
	private Classroom classroom;

	//---------- Constructor -----------

	public School(String name, String areaStudy, Subject subject, Classroom classroom, String buildingsName, String floor) {

		super(buildingsName, floor);

		this.name = name;
		this.areaStudy = areaStudy;
		this.subject = subject;
		this.classroom = classroom;
	}

	//---------- Encapsulation -----------

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaStudy() {
		return areaStudy;
	}

	public void setAreaStudy(String areaStudy) {
		this.areaStudy = areaStudy;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	@Override
	public void open() {

		LocalTime timeNow = LocalTime.now();
		LocalDate actualdate = LocalDate.now();
		DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).format(actualdate);
		LocalTime doorsOpened = LocalTime.of(06,59);
		LocalTime doorClosed = LocalTime.of(16,01);

		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)){
			LOGGER.info(actualdate);
			LOGGER.info(" The School is opened ");
		}else {
			LOGGER.info(" The School is closed, if you need a consult with a teacher, come tomorrow. ");
		}
	}
}
