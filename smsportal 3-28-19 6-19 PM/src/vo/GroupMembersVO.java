package vo;

import java.io.Serializable;

public class GroupMembersVO implements Serializable{
	private int groupMemberId;
	private GroupNamesVO groupNamesVO;
	private StudentVO studentVO;
	public int getGroupMemberId() {
		return groupMemberId;
	}
	public void setGroupMemberId(int groupMemberId) {
		this.groupMemberId = groupMemberId;
	}
	public GroupNamesVO getGroupNamesVO() {
		return groupNamesVO;
	}
	public void setGroupNamesVO(GroupNamesVO groupNamesVO) {
		this.groupNamesVO = groupNamesVO;
	}
	public StudentVO getStudentVO() {
		return studentVO;
	}
	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}
	
	
}
