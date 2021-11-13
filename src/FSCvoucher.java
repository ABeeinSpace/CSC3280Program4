/*
 Aidan Border
 11/10/2021
 CSC 3280
 Honor Code: I will practice academic and personal integrity and excellence of character and expect the same from
 others
*/

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
	public FSCvoucher(int arrivalTime, int ID, String firstName, String lastName, String code) {
		this.arrivalTime = arrivalTime;
		this.ID = ID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.code = code;
//		this.timeStarted = timeStarted;
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

	public String printFinishedMessage(String currentTime) {
		String output = String.format("%s  The car for %s %s is now finished.\n" +
				"           Waiting time in line: %d minutes\n" +
				"           Service time: %d minutes\n" +
				"           Total time: %d minutes", currentTime, firstName, lastName, arrivalTime - timeStarted,
				timeFinished - timeStarted,
				(arrivalTime - timeStarted) + (timeFinished - timeStarted));
		return output;
	}

	@Override
	public String toString() {
		return String.format("           %s %s (%s)\n", firstName, lastName, code);
	}
}
