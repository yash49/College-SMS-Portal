package vo;

import java.io.Serializable;

public class SenderIdVO implements Serializable{
	
	private int senderId;
	private String senderIdName;
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public String getSenderIdName() {
		return senderIdName;
	}
	public void setSenderIdName(String senderIdname) {
		this.senderIdName = senderIdname;
	}
}
