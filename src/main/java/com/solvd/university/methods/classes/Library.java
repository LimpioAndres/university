package com.solvd.university.methods.classes;

import com.solvd.university.interfaces.IEnable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalTime;

public final class Library extends Building implements IEnable {
	private static final Logger LOGGER = LogManager.getLogger(Library.class);
	
	private String nameBook;
	private String descriptionBook;
	private int codeBook;
	private boolean stock;

	//----------- Constructor -----------

	public Library(String nameBook, String descriptionBook, int codeBook, boolean stock, String buildingsName, String floor) {

		super(buildingsName, floor);

		this.nameBook = nameBook;
		this.descriptionBook = descriptionBook;
		this.codeBook = codeBook;
		this.stock = stock;
	}

	//------------ Encapsulation ----------

	public String getNameBook() {
		return nameBook;
	}

	public void setNameBook(String nameBook) {
		this.nameBook = nameBook;
	}

	public String getDescriptionBook() {
		return descriptionBook;
	}

	public void setDescriptionBook(String descriptionBook) {
		this.descriptionBook = descriptionBook;
	}

	public int getCodeBook() {
		return codeBook;
	}

	public void setCodeBook(int codeBook) {
		this.codeBook = codeBook;
	}

	public boolean isStock() {
		return stock;
	}

	public void setStock(boolean stock) {
			this.stock = stock;
	}

	@Override
	public void open() {

		LocalTime timeNow = LocalTime.now();
		LocalTime doorsOpened = LocalTime.of(9, 59);
		LocalTime doorClosed = LocalTime.of(16, 01);

		if (timeNow.isAfter(doorsOpened) && timeNow.isBefore(doorClosed)) {
			LOGGER.info("Library open");
		} else {
			LOGGER.info("The Library will open tomorrow");
		}
	}

}
