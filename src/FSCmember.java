public class FSCmember {
	int arrivalTime;
	int timeStarted;
	int ID;
	String firstName;
	String lastName;
	String code;
	int minutesRemaining;
	FSCmember next;


	//region Constructors
	public FSCmember(int arrivalTime, int timeStarted, int ID, String firstName, String lastName, String code, int minutesRemaining) {
		this.arrivalTime = arrivalTime;
		this.timeStarted = timeStarted;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.minutesRemaining = minutesRemaining;
	}

	public FSCmember() {
	}
	//endregion


	//region Getters and Setters
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(int timeStarted) {
		this.timeStarted = timeStarted;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getMinutesRemaining() {
		return minutesRemaining;
	}

	public void setMinutesRemaining(int minutesRemaining) {
		this.minutesRemaining = minutesRemaining;
	}
	//endregion
}