public class FSCmember {
	int arrivalTime;
	int timeStarted;
	int ID;
	String firstName;
	String lastName;
	String code;
	int minutesRemaining;
	FSCmember next;
	boolean didFinishWork;


	//region Constructors
	public FSCmember(int arrivalTime, int ID, String firstName, String lastName, String code, int minutesRemaining) {
		this.arrivalTime = arrivalTime;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
		this.minutesRemaining = minutesRemaining;
		didFinishWork = false;
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

	public boolean isServiceCompleted() {
		return (minutesRemaining == 0);
	}

	public FSCmember getNext() {
		return next;
	}

	public void setNext(FSCmember next) {
		this.next = next;
	}

	//endregion


	@Override
	public String toString() {
		return "FSCmember{" +
				"arrivalTime=" + arrivalTime +
				", timeStarted=" + timeStarted +
				", ID=" + ID +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", code='" + code + '\'' +
				", minutesRemaining=" + minutesRemaining +
				", next=" + next +
				", didFinishWork=" + didFinishWork +
				'}';
	}
}
