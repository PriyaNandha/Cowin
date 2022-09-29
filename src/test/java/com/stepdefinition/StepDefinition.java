package com.stepdefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.cowin.CowinBaseClass;
import com.config.cowin.CowinConfigHelper;
import com.cowin.runner.CowinRunner;
import com.pom.cowin.CowinPom;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends CowinBaseClass {

	public static WebDriver driver = CowinRunner.driver;
	public static WebDriverWait xwait = new WebDriverWait(driver, 30);
	public static JavascriptExecutor js = (JavascriptExecutor) driver;
	
	CowinPom cwpom = new CowinPom(driver);

	@Given("user Launch The Application")
	public void user_launch_the_application() throws IOException {
		
		driver.get(CowinConfigHelper.getInstance().getUrl());

	}

	@When("user Select The State District And Click Search")
	public void user_select_the_state_district_and_click_search() throws InterruptedException, IOException {

		WebElement state = cwpom.getState();
		jsScroll(state);
//		js.executeScript("arguments[0].scrollIntoView();", state);
		sleep();
		jsClick(state);
//		js.executeScript("arguments[0].click();", state);
//		driver.findElements(By.xpath("//span[@class='mat-option-text']"));
		List<WebElement> stateList = cwpom.getStateList();

		for (WebElement states : stateList) {
			if (states.getText().trim().equalsIgnoreCase(CowinConfigHelper.getInstance().getState())) {
				jsClick(state);
//				js.executeScript("arguments[0].click();", states);
				break;
			}
		}

		sleep();
		WebElement selectDistrict = cwpom.getDistrict();

//		xwait.until(ExpectedConditions.elementToBeClickable(selectDistrict));

		jsClick(selectDistrict);
//		js.executeScript("arguments[0].click();", selectDistrict);
//		driver.findElements(By.xpath("//span[@class='mat-option-text']"));
		List<WebElement> allDistricts = cwpom.getDistictList();

		for (WebElement district : allDistricts) {
			if (district.getText().trim().equalsIgnoreCase(CowinConfigHelper.getInstance().getDistrict())) {
				jsClick(district);
//				js.executeScript("arguments[0].click();", district);
				break;
			}
		}

	}

	@When("user Select The Age Dose Paid And Dosetype")
	public void user_select_the_age_dose_paid_and_dosetype() throws IOException {
//		driver.findElement(By.xpath("//button[contains(text(),'Search')]"))
		
		WebElement searchbtn = cwpom.getSearchBtn();
		jsClick(searchbtn);
		
//		js.executeScript("arguments[0].click();", searchbtn);
//		driver.findElements(By.xpath("//input[@type='checkbox']//parent::div"))
		
		List<WebElement> alldata = cwpom.getAllData();
		xwait.until(ExpectedConditions.visibilityOfAllElements(alldata));

		for (WebElement data : alldata) {

			if (data.getText().trim().equalsIgnoreCase(CowinConfigHelper.getInstance().getAge())) { // "arguments[0].click();", element
				data.click();
//					js.executeScript("arguments[0].click();", data);
				System.out.println(data.getText());
//					Thread.sleep(2000);
			} else if (data.getText().trim().equalsIgnoreCase(CowinConfigHelper.getInstance().getDose())) {
				data.click();
//					js.executeScript("arguments[0].click();", data);
				System.out.println(data.getText());
//					Thread.sleep(2000);
			} else if (data.getText().trim().equalsIgnoreCase(CowinConfigHelper.getInstance().getPaid())) {
				data.click();
//					js.executeScript("arguments[0].click();", data);
				System.out.println(data.getText());
//					Thread.sleep(2000);
			} else if (data.getText().trim().equalsIgnoreCase(CowinConfigHelper.getInstance().getCovishield())) {
				data.click();
//					js.executeScript("arguments[0].click();", data);
				System.out.println(data.getText());
//					Thread.sleep(2000);
			}
		}

	}

	@When("user Validate The Entered Data With Result")
	public void user_validate_the_entered_data_with_result() {

//		driver.findElements(By.xpath("//h5[@class='center-name-title accessibility-plugin-ac']"));
		List<WebElement> allHospitals = cwpom.getAllHospitals();
				
		System.out.println("THE CENTERS ACCORDING TO REQUIRED CONDITIONS: ");
		for (WebElement hospital : allHospitals) {
			if (hospital.isDisplayed()) {
				System.out.println(hospital.getText());
			}
		}

	}

	@Then("close The Application Url")
	public void close_the_application_url() {
		closeUrl();
	}

}
