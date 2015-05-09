package com.tour.commons.base;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.tour.commons.global.CS;
import com.tour.commons.utils.RJLog;

@SuppressWarnings("serial")
public class BaseAction extends ActionSupport implements SessionAware,
		ServletRequestAware ,ServletResponseAware{

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	/**
	 * session对象
	 */
	public Map<String, Object> session;

	/**
	 * request对象
	 */
	public HttpServletRequest request;
	
	public HttpServletResponse response;


	/**
	 * 输出
	 */
	public InputStream inputStream;

	/**
	 * @Description: TODO
	 */
	public static final String LIST_SUCCESS = "LIST_SUCCESS";
	public static final String VIEW_SUCCESS = "VIEW_SUCCESS";
	public static final String EDIT_SUCCESS = "EDIT_SUCCESS";
	public static final String ADD_SUCCESS = "ADD_SUCCESS";

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void responseJson(boolean rs, String msg) {
		try {
			String json = "{\"success\":" + rs + ",\"msg\":\"" + msg + "\"}";
			if(!msg.startsWith("[") && !msg.startsWith("{")){ RJLog.debug(msg);}
			setInputStream(new ByteArrayInputStream(json.getBytes(CS.ENCODE)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void responseJson(boolean rs, JSONArray _msg) {
		String msg = _msg.toString();
		try {
			String json = "{\"success\":" + rs + ",\"msg\":" + msg + "}";
			if(!msg.startsWith("[") && !msg.startsWith("{")){ RJLog.debug(msg);}
			setInputStream(new ByteArrayInputStream(json.getBytes(CS.ENCODE)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void responseJson(boolean rs, JSONObject _msg) {
		String msg = _msg.toString();
		try {
			String json = "{\"success\":" + rs + ",\"msg\":" + msg + "}";
//			String json = "{\"success\":" + rs + ",\"msg\":\"" + msg + "\"}";
			if(!msg.startsWith("[") && !msg.startsWith("{")){ RJLog.debug(msg);}
			setInputStream(new ByteArrayInputStream(json.getBytes(CS.ENCODE)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void responseJson(String msg) {
		try {
			setInputStream(new ByteArrayInputStream(msg.getBytes(CS.ENCODE)));
			if(!msg.startsWith("[") && !msg.startsWith("{")){ RJLog.debug(msg);}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void responseJson(int rscount, JSONArray _msg) {
		try {
			String json = "{\"total\":" + rscount + ",\"rows\":" + _msg + "}";
			setInputStream(new ByteArrayInputStream(json.getBytes(CS.ENCODE)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see org.apache.struts2.interceptor.ServletResponseAware#setServletResponse(javax.servlet.http.HttpServletResponse)
	 */
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
}
