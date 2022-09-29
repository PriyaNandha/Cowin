package com.baseclass.cowin;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class CowinBaseClass {
	

	public static WebDriver driver;
	public static JavascriptExecutor js;
	
	public static WebDriver browserLaunch(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\GOD\\eclipse-workspace\\MiniProject2\\Browser\\chromedriver.exe");
			
			driver= new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("edge")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\GOD\\eclipse-workspace\\MiniProject2\\Browser\\chromedriver.exe");
			
			driver= new EdgeDriver();
			
		}else {
			System.out.println("Invalid browser");
		}
		driver.manage().window().maximize();
		return driver;

	}
	public static void launchUrl(String element) {
		
		driver.get(element);
		
	}
	
	public static  void navigate() {
		driver.navigate().back();
		
	}
	public static void explicitWaitForElementVisibility(WebElement element) {

		WebDriverWait xwait = new WebDriverWait(driver, 50);
		xwait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void clickOnWebelement(WebElement element) {
		
		explicitWaitForElementVisibility(element);
//		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			
		element.click();
//		}
	}
	
	public static void selectDropDownOption(WebElement element, String option, String value) {

		explicitWaitForElementVisibility(element);
		
		Select s = new Select(element);
		if (option.equalsIgnoreCase("value")) {
			s.selectByValue(value);
		} else if (option.equalsIgnoreCase("visibletext")) {
			s.selectByVisibleText(value);
		} else if (option.equalsIgnoreCase("index")) {
			s.selectByIndex(Integer.parseInt(value));
		}
}
	public static void screenshot(String filename) throws Exception {
		Date d = new Date();
		String filename1 = d.toString().replace(':', '_') + ".png";
//		TakesScreenshot screenshot = (TakesScreenshot) driver;
		Files.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File("C:\\Users\\GOD\\eclipse-workspace\\FaceBook\\Screenshot" + filename +" " + filename1));
	}
	
	public static void sleep() throws InterruptedException {
		
		Thread.sleep(5000);
	}
	
	public static void clickOnElement(WebElement element) {
		
		element.click();
		
		
	}

	public static void userInput(WebElement element, String value) {
		
		element.sendKeys(value);
		
	}
	
	public static void jsClick(WebElement element) {
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click;", element);
			
	}
	public static void jsScroll(WebElement element) {
		js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
			
	}
	public static void closeUrl() {
		driver.close();
	}
	
	public static void quit() {
		driver.quit();
	}
	
	



}
