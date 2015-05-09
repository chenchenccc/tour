package com.tour.commons.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnect {
	public static String getHTML(String httpUrl, String Charset) {
		String html = "";

		try {
			URL url = new URL(httpUrl.toString());
			StringBuffer document = new StringBuffer();
			try {
				URLConnection urlCon = (HttpURLConnection) url.openConnection();
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(urlCon.getInputStream()));
				String Result = "";
				while ((Result = reader.readLine()) != null) {
					document.append(Result);
					// System.out.println(Result);
				}

				html = document.toString();
			} catch (IOException e) {
				html = "服务未响应";

			}
		} catch (MalformedURLException e) {
			html = "不支持的协议";

		}

		return html;
	}
}
