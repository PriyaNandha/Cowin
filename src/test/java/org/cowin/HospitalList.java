package org.cowin;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HospitalList {

	public static WebDriver driver;

	public static void sub_Method() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GOD\\eclipse-workspace\\MiniProject2\\Browser\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cowin.gov.in/");

		WebElement state = driver.findElement(By.xpath("//div[@class='page-wrapper']//descendant::span[text()='Select Your State']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", state);
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", state);

		List<WebElement> stateList = driver
				.findElements(By.xpath("//span[@class='mat-option-text']"));

		for (WebElement states : stateList) {
			if (states.getText().trim().equals("Tamil Nadu")) {
				js.executeScript("arguments[0].click();", states);
				break;
			}
		}

		WebDriverWait xwait = new WebDriverWait(driver, 30);
		WebElement selectDistrict = driver.findElement(By.xpath("//div[@class='page-wrapper']//descendant::span[contains(text(),'Select District')]"));

		xwait.until(ExpectedConditions.elementToBeClickable(selectDistrict));
		js.executeScript("arguments[0].click();", selectDistrict);

		List<WebElement> allDistricts = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
		ArrayList<String> districts = new ArrayList<String>();
		for (WebElement district : allDistricts) {
			districts.add(district.getText());
			if (districts.equals("Chennai")) {
				js.executeScript("arguments[0].click();", district);
				break;
			}
		}
	    	   WebElement search=driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
	    	   js.executeScript("arguments[0].click();",search);
	    	   
	    	   List<WebElement> alldata= driver.findElements(By.xpath("//label[@tabindex='0']"));
	    	   xwait.until(ExpectedConditions.visibilityOfAllElements(alldata));
	    	   
	    	   for (WebElement data : alldata) {
				if(data.getText().equals("18+")) {
					js.executeScript("arguments[0].click();", data);
				}
				if(data.getText().equals("Dose 2")) {
					js.executeScript("arguments[0].click();", data);
				}
				if(data.getText().equals("Paid")) {
					js.executeScript("arguments[0].click();", data);
				}
				if(data.getText().equals("Covishield")) {
					js.executeScript("arguments[0].click();", data);
				}
			}
	    	   List<WebElement> validation = driver.findElements(By.xpath("//ul/li/span[2][@tabindex='0']"));
	    	   System.out.println("VERIFICATION OF DATAS ENTERED: ");
	    	   for (WebElement checkData : validation) {
	    		   if(checkData.getText().equals("18+")) {
	    			   System.out.println("verified that the age is 18+");
	    		   }
	    		   if(checkData.getText().equals("2")) {
	    			   System.out.println("verified that the dose in Dose 2");
	    		   }
	    		   if(checkData.getText().equals("Paid")) {
	    			   System.out.println("verified that the filtered hospitals are Paid not free");
	    		   }
	    		   if(checkData.getText().equals("COVISHIELD")) {
	    			   System.out.println("verified that the vaccine is Covishield");
	    		   }
	    		   
				
			}
	    	   List<WebElement> allHospitals = driver.findElements(By.xpath("//h5[@class='center-name-title accessibility-plugin-ac']"));
	    	   System.out.println("THE CENTERS ACCORDING TO REQUIRED CONDITIONS: ");
	    	   for (WebElement hospital : allHospitals) {
				if(hospital.isDisplayed()) {
					System.out.println(hospital.getText());
				}
			}

	}

	public static void main(String[] args) throws InterruptedException {

		sub_Method();

	}
}
