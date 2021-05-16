package vo;
import java.io.Serializable;

import vo.LoginVO;

public class StaffVO implements Serializable{

	private int staffId;
	private String staffFirstName;
	private String staffLastName;
	private String staffMobile;
	private String staffGender;
	private String staffDesignation;
	private String staffBranch;
	private String staffAddress;
	private String staffEmail;
	private LoginVO loginVO;
	
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	
	public String getStaffFirstName() {
		return staffFirstName;
	}
	public void setStaffFirstName(String staffFirstName) {
		this.staffFirstName = staffFirstName;
	}
	public String getStaffLastName() {
		return staffLastName;
	}
	public void setStaffLastName(String staffLastName) {
		this.staffLastName = staffLastName;
	}
	public String getStaffMobile() {
		return staffMobile;
	}
	public void setStaffMobile(String staffMobile) {
		this.staffMobile = staffMobile;
	}
	public String getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffDesignation() {
		return staffDesignation;
	}
	public void setStaffDesignation(String staffDesignation) {
		this.staffDesignation = staffDesignation;
	}
	public String getStaffBranch() {
		return staffBranch;
	}
	public void setStaffBranch(String staffBranch) {
		this.staffBranch = staffBranch;
	}
	
	
}
