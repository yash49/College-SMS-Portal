package scheduler;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public final void contextInitialized(final ServletContextEvent sce) {
    	
    	System.out.println("++++++++   Scheduler started   ++++++++");
		  
	  	Timer time = new Timer(); // Instantiate Timer Object
		ScheduledTask st = new ScheduledTask(); // Instantiate SheduledTask class
		time.schedule(st, 0, 60000); // Create Repetitively task for every 60 secs
		
    }

    @Override
    public final void contextDestroyed(final ServletContextEvent sce) {
    	
    	System.out.println("++++++++   Scheduler stopped   ++++++++");
    	
    }
}
		  	
