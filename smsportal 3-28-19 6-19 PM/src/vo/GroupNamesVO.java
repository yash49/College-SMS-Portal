package vo;

import java.io.Serializable;

public class GroupNamesVO implements Serializable{
	private int groupNameId;
	private String groupName;
	private LoginVO loginVO;
	public int getGroupNameId() {
		return groupNameId;
	}
	public void setGroupNameId(int groupNameId) {
		this.groupNameId = groupNameId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public LoginVO getLoginVO() {
		return loginVO;
	}
	public void setLoginVO(LoginVO loginVO) {
		this.loginVO = loginVO;
	}

}
