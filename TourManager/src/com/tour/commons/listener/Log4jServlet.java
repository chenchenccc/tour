package com.tour.commons.listener;

import java.io.FileInputStream;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.tour.commons.global.DB;

@SuppressWarnings("serial")
public class Log4jServlet extends HttpServlet {

	public Log4jServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		String prefix = DB.contextPath =  getServletContext().getRealPath("/");
		String file = getInitParameter("log4j-init-file");
		// if the log4j-init-file is not set, then no point in trying
		if (file != null) {
			PropertyConfigurator.configure(prefix + file);
		}
		System.out.println("----------log4j----------");
		
		//
		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream(this.getClass().getClassLoader().getResource("config.properties").getPath());
			properties.load(fis);
			
			//
			String hdpi = properties.getProperty("hdpi", "");
			DB.hdipWidth = Integer.parseInt(hdpi.split("\\*")[0]);
			DB.hdipHeight = Integer.parseInt(hdpi.split("\\*")[1]);
            
			//
			String mdpi =   properties.getProperty("mdpi", "");
			DB.mdipWidth = Integer.parseInt(mdpi.split("\\*")[0]);
			DB.mdipHeight = Integer.parseInt(mdpi.split("\\*")[1]);
			
			//
			String ldpi =   properties.getProperty("ldpi", "");
			DB.ldipWidth = Integer.parseInt(ldpi.split("\\*")[0]);
			DB.ldipHeight = Integer.parseInt(ldpi.split("\\*")[1]);			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		//
		DB.contextPath  = this.getServletContext().getRealPath("/");
		
		// 
//		new Thread(new LogServerThread()).start();
		
		ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
		System.out.println("-------------------Spring ApplicationContext---------------");
		DB.applicationContext = applicationContext;
		
		//new MainTest().test(); //test
		
		//
//		new TimerTaskSchedule().startListen();
//		new ScheduleSendMailTask().startListening();
	}

}
