public class FSCvoucher {
	int arrivalTime;
	int ID;
	String firstName;
	String lastName;
	String code;
	int timeStarted;
	int timeFinished;
	FSCvoucher next;


	//region Constructors
	public FSCvoucher(int arrivalTime, int ID, String firstName, String lastName, String code, int timeStarted, int timeFinished) {
		this.arrivalTime = arrivalTime;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.timeStarted = timeStarted;
		this.timeFinished = timeFinished;
	}

	public FSCvoucher() {
	}
	//endregion

	//region Getters and Setters
	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
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

	public int getTimeStarted() {
		return timeStarted;
	}

	public void setTimeStarted(int timeStarted) {
		this.timeStarted = timeStarted;
	}

	public int getTimeFinished() {
		return timeFinished;
	}

	public void setTimeFinished(int timeFinished) {
		this.timeFinished = timeFinished;
	}
	//endregion
}
