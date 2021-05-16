package vo;

import java.io.Serializable;

public class SmsTemplateVO implements Serializable{

	private int smsTemplateId;
	private String smsTemplateName;
	private String smsTemplateText;
	private LoginVO loginVO;
	
	public int getSmsTemplateId() {
		return smsTemplateId;
	}
	public void setSmsTemplateId(int smsTemplateId) {
		this.smsTemplateId = smsTemplateId;
	}
	public String getSmsTemplateName() {
		return smsTemplateName;
	}
	
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}
	public void setSmsTemplateName(String smsTemplateName) {
		this.smsTemplateName = smsTemplateName;
	}
	public String getSmsTemplateText() {
		return smsTemplateText;
	}
	public void setSmsTemplateText(String smsTemplateText) {
		this.smsTemplateText = smsTemplateText;
	}
	
	
}
