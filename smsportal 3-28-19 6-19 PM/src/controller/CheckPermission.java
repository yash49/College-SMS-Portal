package controller;

public class CheckPermission {
	
	public String checkPermission(String userType)
	{
		if(userType.equalsIgnoreCase("staff"))
			return "no";
		else if(userType.equalsIgnoreCase("admin"))
			return "yes";
		else
			return "login";
	}
	
}
