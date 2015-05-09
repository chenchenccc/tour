package com.tour.commons.utils;

import org.apache.log4j.Logger;


/**
 * 
 * @author chenrh
 * @date 2015-5-8
 */
public class RJLog {

	/**
	 * log
	 */
	 private static Logger log = Logger.getLogger(RJLog.class); // log4j
//	private static final Log log = LogFactory.getLog(); // log 5j
	
//	//当前操作的用户ID
//	public static String logUserid;
//	
//	//当前操作的用户登录名
//	public static String loginName;

	public static void info(String msg) {
		log.info(msg);
	}
	
	public static void error(Throwable e) {
		e.printStackTrace();
//		Malfunction mal = new Malfunction();
//		mal.setTitle(e.getMessage());
//		mal.setContent(RJLogPact.pactLog(e));
//		new MalfunctionServiceImpl().sendMail(mal);
		log.error("error", e);
	}
	
	public static void debug(String msg) {
		log.debug(msg);
	}
	
	public static void warn(String msg) {
		log.warn(msg);
	}
	
}
