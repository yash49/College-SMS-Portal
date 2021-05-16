package scheduler;
import java.util.TimerTask;

import controller.ConvertingDateTime;
import controller.SendSms;
import dao.FutureSmsDAO;
import vo.FutureSmsVO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * 
 * @author Dhinakaran P.
 */
// Create a class extends with TimerTask
public class ScheduledTask extends TimerTask {

	FutureSmsDAO futureSmsDAO = new FutureSmsDAO();
	SendSms sendSms = new SendSms();
	ConvertingDateTime convertingDateTime = new ConvertingDateTime();
	
	// Add your task here
	public void run() throws IllegalStateException {
		
		List<FutureSmsVO> futureSmsList = futureSmsDAO.getFutureSms();
		
		for (FutureSmsVO futureSmsVO : futureSmsList) {
			if(!futureSmsVO.getIsSent().equalsIgnoreCase("yes"))
			{
				if(futureSmsVO.getTimestamp() < convertingDateTime.getCurrentTimestamp())
				{
					sendSms.sendSMS(futureSmsVO.getMobile(), futureSmsVO.getMessage(), futureSmsVO.getSenderId(), futureSmsVO.getLoginVO());
					futureSmsVO.setIsSent("yes");
					futureSmsDAO.updateFutureSms(futureSmsVO);
				}
			}
		}
		
	}
}