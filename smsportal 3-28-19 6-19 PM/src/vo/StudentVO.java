package vo;

import java.io.Serializable;

public class StudentVO implements Serializable{
	
	private int studentId;
	private String studentFirstName;
	private String studentLastName;
	private String studentMobile;
	private String studentEmail;
	private String studentGender;
	private String studentEnrollmentNumber;
	private String studentShift;
	private BranchVO branchVO;
	private SemesterVO semesterVO;
	private ClassVO classVO;
	private LoginVO loginVO;
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getStudentMobile() {
		return studentMobile;
	}
	public void setStudentMobile(String studentMobile) {
		this.studentMobile = studentMobile;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentGender() {
		return studentGender;
	}
	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}
	public String getStudentEnrollmentNumber() {
		return studentEnrollmentNumber;
	}
	public void setStudentEnrollmentNumber(String studentEnrollmentNumber) {
		this.studentEnrollmentNumber = studentEnrollmentNumber;
	}
	public String getStudentShift() {
		return studentShift;
	}
	public void setStudentShift(String studentShift) {
		this.studentShift = studentShift;
	}
	public BranchVO getBranchVO() {
		return branchVO;
	}
	public void setBranchVO(BranchVO branchVO) {
		this.branchVO = branchVO;
	}
	public SemesterVO getSemesterVO() {
		return semesterVO;
	}
	public void setSemesterVO(SemesterVO semesterVO) {
		this.semesterVO = semesterVO;
	}
	public ClassVO getClassVO() {
		return classVO;
	}
	public void setClassVO(ClassVO classVO) {
		this.classVO = classVO;
	}
	
	
}
