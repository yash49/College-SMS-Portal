package controller;

import java.sql.Timestamp;
import java.util.Date;

public class ConvertingDateTime {
	
	public long convertToTimestamp(String dateTime)
	{
		dateTime += ":00";
		Timestamp databaseTimestamp = Timestamp.valueOf(dateTime.replace("T", " "));
		long finalTimestamp=databaseTimestamp.getTime();
		return  finalTimestamp;
	}
	
	public String convertToDateTime(long timeStamp)
	{
		Date date = new Date();
        String databaseTimestampString=new Timestamp(timeStamp).toString();
        String databaseDateTime = databaseTimestampString.substring(0,databaseTimestampString.length()-5);
        return databaseDateTime;
	}
	
	public long getCurrentTimestamp()
	{
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		long finalCurrentTimestamp = currentTimeStamp.getTime();
        return finalCurrentTimestamp;
	}
}
