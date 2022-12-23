package com.solvd.university.methods.classes;

import com.solvd.university.exceptions.NoCampusNameException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Campus {
	
	private String campusName;
	private String generalLocation;
	private String motto;
	private String rectorFullName;

	private static final Logger LOGGER = LogManager.getLogger(Campus.class);

	//----------- Constructor -----------

	public Campus(String campusName, String generalLocation, String motto, String rectorFullName) {

		try {
			if (campusName == "") {
				throw new NoCampusNameException("No assigned campus name");
			}
		}catch(NoCampusNameException e){
			LOGGER.error("The campus name is mandatory, please insert a name");
		}
		this.campusName = campusName;
		this.generalLocation = generalLocation;
		this.motto = motto;
		this.rectorFullName = rectorFullName;
	}

	//---------- Encapsulation ----------

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;

	}

	public String getGeneralLocation() {
		return generalLocation;
	}

	public void setGeneralLocation(String generalLocation) {
		this.generalLocation = generalLocation;
	}

	public String getMotto() {
		return motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getRectorFullName() {
		return rectorFullName;
	}

	public void setRectorFullName(String rectorFullName) {
		this.rectorFullName = rectorFullName;
	}
	@Override
	public String toString() {
		return 	"Name of university: " + campusName +" | "+ " Address : " + generalLocation + "\n" +
				"Motto: " + motto +" | "+ " Rector Full Name: " + rectorFullName + "\n";
	}


}
