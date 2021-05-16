package scheduler;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import dao.AdminIndexDAO;
import dao.ComplainDAO;
import dao.StaffIndexDAO;
import vo.ComplainVO;
import vo.LoginVO;



//Main class
public class SchedulerMain {
	public static void main(String args[]) throws InterruptedException {
/*
		Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 30000); // Create Repetitively task for every 30 secs
		*/
		//for demo only.
		/*for (int i = 0; i <= 10; i++) {
			System.out.println("Execution in Main Thread...." + i);
			Thread.sleep(1000);
			
			
			if (i==10) {
				//System.exit(0);
			}
		}*/
		
	/*	Date d = new Date();
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		String dateString = date.format(d);

		System.out.println(dateString);*/
		
	/*	LoginVO loginVO = new LoginVO();
		loginVO.setId(5);
		System.out.println(StaffIndexDAO.getMyStudents(loginVO));*/

/*		ComplainVO complainVO = new ComplainVO();
		ComplainDAO complainDAO = new ComplainDAO();
		complainVO.setComplainId(13);
		List<ComplainVO> ls = complainDAO.editComplain(complainVO);
		ComplainVO complainVO2 = (ComplainVO) ls.get(0);
		String complainFilePath = complainVO2.getComplainFilePath()+complainVO2.getComplainFileName();
		File file = new File(complainFilePath);
		
		file.delete();*/
	}
}