package vo;

import java.io.Serializable;

public class FutureSmsVO implements Serializable{
	
	private int futureSmsId;
	private String mobile;
	private String message;
	private String senderId;
	private String isSent;
	private long timestamp;
	private LoginVO loginVO;
	
	public String getIsSent() {
		return isSent;
	}
	public void setIsSent(String isSent) {
		this.isSent = isSent;
	}
	
	
	public int getFutureSmsId() {
		return futureSmsId;
	}
	public void setFutureSmsId(int futureSmsId) {
		this.futureSmsId = futureSmsId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	
	
	
	

}
