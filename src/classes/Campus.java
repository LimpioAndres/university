package classes;


import exceptions.NoCampusNameException;

public class Campus {
	
	private String campusName;
	private String generalLocation;
	private String motto; // "From people we come, to people us go"
	private String rectorFullName;

	public Campus(String campusName, String generalLocation, String motto, String rectorFullName) {
		setCampusName(campusName);
		this.generalLocation = generalLocation;
		this.motto = motto;
		this.rectorFullName = rectorFullName;
	}

	public String getCampusName() {
		return campusName;
	}

	public void setCampusName(String campusName) {
		this.campusName = campusName;
		try {
			if (campusName != null) {
				this.campusName = campusName;
			}else {
				throw new NoCampusNameException("No assigned campus name");
			}
		}catch(NoCampusNameException e){
			System.out.println("The campus name is mandatory, please insert a name");
		}
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
