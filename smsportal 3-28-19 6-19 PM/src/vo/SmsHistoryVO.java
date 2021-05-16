package vo;

import java.io.Serializable;

public class SmsHistoryVO implements Serializable{
	
	private int smsHistoryId;
	public int getSmsHistoryId() {
		return smsHistoryId;
	}
	public void setSmsHistoryId(int smsHistoryId) {
		this.smsHistoryId = smsHistoryId;
	}
	private String mobileNo;
	private String date; 
	private String message;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	private String senderId;
	private LoginVO loginVO;
	
	
	
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSenderId() {
		return senderId;
	}
	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

}
