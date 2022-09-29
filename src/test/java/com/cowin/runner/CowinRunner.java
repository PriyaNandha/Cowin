package com.cowin.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.baseclass.cowin.CowinBaseClass;
import com.config.cowin.CowinConfigHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\feature\\Cowin.feature",
glue = "com.stepdefinition")

public class CowinRunner {

	public static WebDriver driver;
	@BeforeClass
	public static void setUp() throws IOException {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\GOD\\eclipse-workspace\\Cowin\\Browser\\chromedriver.exe");
		String browser = CowinConfigHelper.getInstance().getBrowser();
		driver = CowinBaseClass.browserLaunch(browser);
		

	}
	@AfterClass
	public static void tearDown() {
		driver.close();
		
	}
}
