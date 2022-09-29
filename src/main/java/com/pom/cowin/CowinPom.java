package com.pom.cowin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CowinPom {
	
	public WebDriver driver;
	
	public CowinPom(WebDriver driver2) {
		
		this.driver=driver2;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='page-wrapper']//descendant::span[text()='Select Your State']")
	private WebElement state;
	
	
	@FindBy(xpath = "//div[@class='page-wrapper']//descendant::span[contains(text(),'Select District')]")
	private WebElement district;
	
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> statelist;
	
	@FindBy(xpath = "//span[@class='mat-option-text']")
	private List<WebElement> distictlist;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//input[@type='checkbox']//parent::div")
	private List<WebElement> alldata;
	
	@FindBy(xpath = "//input[@type='checkbox']//parent::div")
	private List<WebElement> allHospitals;
	
	public List<WebElement> getAllHospitals() {
		return allHospitals;
	}
	
	
	public List<WebElement> getAllData() {
		return alldata;
	}
	
	public WebElement getSearchBtn() {
		return searchbtn;
	}
	
	public List<WebElement> getDistictList() {
		return distictlist;
	}
	
	public List<WebElement> getStateList() {
		return statelist;
	}
	public WebElement getDistrict() {
		
		return district;
		
	}
	public WebElement getState() {
		return state;
	}

	
	
}
