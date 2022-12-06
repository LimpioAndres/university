package classes;

public class Campus {
	
	private String campusName;
	private String generalLocation;
	private String motto;
	private String rectorFullName;

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

	public String toString() {
		return 	" Name of university: " + campusName + "\n" +
				" Address of university: " + generalLocation + "\n" +
				" Motto: " + motto + "\n" +
				" Rector Full Name: " + rectorFullName;
	}
}
