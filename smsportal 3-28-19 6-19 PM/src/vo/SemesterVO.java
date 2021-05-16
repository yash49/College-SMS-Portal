package vo;

import java.io.Serializable;

public class SemesterVO implements Serializable{
	
	private int semesterId;
	private int semesterNumber;
	
	public int getSemesterId() {
		return semesterId;
	}
	public void setSemesterId(int semesterId) {
		this.semesterId = semesterId;
	}
	public int getSemesterNumber() {
		return semesterNumber;
	}
	public void setSemesterNumber(int semesterNumber) {
		this.semesterNumber = semesterNumber;
	}
}
