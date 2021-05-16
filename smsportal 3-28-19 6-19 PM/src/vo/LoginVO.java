package vo;

import java.io.Serializable;

public class LoginVO implements Serializable{
	private int id;
	private String email;
	private String password;
	private String userRoll;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRoll() {
		return userRoll;
	}
	public void setUserRoll(String userRoll) {
		this.userRoll = userRoll;
	}
}
