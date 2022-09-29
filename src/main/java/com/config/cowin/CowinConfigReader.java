package com.config.cowin;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CowinConfigReader {

	private Properties p;
	
	public CowinConfigReader () throws IOException {
		
		File f = new File("C:\\Users\\GOD\\eclipse-workspace\\Cowin\\src\\main\\java\\com\\config\\cowin\\Cowin.properties");
		
		FileInputStream fi = new FileInputStream(f);
		
		p = new Properties();
		
		p.load(fi);
		
	}
	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
		
	}

	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}
	public String getState() {
		String state = p.getProperty("state");
		
		return state;
	}
	public String getDistrict() {
		String district =p.getProperty("chennai");
		return district;
	}
	public String getAge() {
		String age = p.getProperty("age");
		return age;
	}
	public String getDose() {
		String dose = p.getProperty("dose");
		return dose;
	}
	public String getPaid() {
		String paid = p.getProperty("paid");
		return paid;
	}
	public String getCovishield() {
		String covishield = p.getProperty("covishield");
		return covishield;
	}
	
	
	
	
	
		
	

		
}
