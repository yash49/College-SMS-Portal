package vo;

import java.io.Serializable;

public class ComplainVO implements Serializable{
	
	private int complainId;
	private String complainSubject;
	private String complainDescription;
	private String complainDate;
	private String complainReply;
	private String complainReplyDate;
	private String complainStatus;
	private String complainFileName;
	private String complainFilePath;
	private LoginVO loginVO;
	
	
	public String getComplainFileName() {
		return complainFileName;
	}
	public void setComplainFileName(String complainFileName) {
		this.complainFileName = complainFileName;
	}
	public String getComplainFilePath() {
		return complainFilePath;
	}
	public void setComplainFilePath(String complainFilePath) {
		this.complainFilePath = complainFilePath;
	}
	public int getComplainId() {
		return complainId;
	}
	public void setComplainId(int complainId) {
		this.complainId = complainId;
	}
	public String getComplainSubject() {
		return complainSubject;
	}
	public void setComplainSubject(String complainSubject) {
		this.complainSubject = complainSubject;
	}
	public String getComplainDescription() {
		return complainDescription;
	}
	public void setComplainDescription(String complainDescription) {
		this.complainDescription = complainDescription;
	}
	public String getComplainDate() {
		return complainDate;
	}
	public void setComplainDate(String complainDate) {
		this.complainDate = complainDate;
	}
	public String getComplainReply() {
		return complainReply;
	}
	public void setComplainReply(String complainReply) {
		this.complainReply = complainReply;
	}
	public String getComplainReplyDate() {
		return complainReplyDate;
	}
	public void setComplainReplyDate(String complainReplyDate) {
		this.complainReplyDate = complainReplyDate;
	}
	public String getComplainStatus() {
		return complainStatus;
	}
	public void setComplainStatus(String complainStatus) {
		this.complainStatus = complainStatus;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
}
