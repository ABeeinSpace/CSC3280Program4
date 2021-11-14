/*
 USING LATE PASS
 Aidan Border
 11/10/2021
 CSC 3280
 Honor Code: I will practice academic and personal integrity and excellence of character and expect the same from
 others
*/

public class FSCmember {
	private int arrivalTime;
	private int timeStarted;
	private int ID;
	private String firstName;
	private String lastName;
	private String code;
	private int minutesRemaining;
	private FSCmember next;
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

	/*Empty constructor for completeness' sake.*/
	public FSCmember() {
	}
	//endregion


	//region Getters and Setters
	/*GetArrivalTime()
	* */
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
}
