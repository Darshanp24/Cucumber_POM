package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {

	private static WebDriver driver;
	//HomePage hp = new HomePage(driver);
	//Locators
	private By Username = By.xpath("//input[@id='inputEmail']");
	private By Password = By.xpath("//input[@id='inputPassword']");
	private By SignIn = By.xpath("//button[text()='Sign in']");
	private By listElements = By.xpath("//*[@id='test-2-div']//li");
	private By secondBatch = By.xpath("(//*[@id=\"test-2-div\"]//li/span)[2]");
	private By dropDown = By.xpath("//button[@id='dropdownMenuButton']");
	private By dropDownvalue = By.xpath("//div[@aria-labelledby='dropdownMenuButton']//a");
	private By firstButton = By.xpath("//div[@id='test-4-div']//*[@class='btn btn-lg btn-primary']");
	private By secondButton = By.xpath("//div[@id='test-4-div']//*[@class='btn btn-lg btn-secondary']");
	private By FifthButton = By.xpath("//*[@id='test-5-div']//*[@type='button']");
	private By successMessage = By.xpath("//div[@id='test5-alert']");
	
	
	//constructor
	public HomePage (WebDriver driver){
		this.driver = driver;
	}

	public void launchURL(String url){
		driver.get(url);
	}

	public String getHomePageTitle(){
		return driver.getTitle();
	}

	public static boolean verifyWebElement(By wd) {
		if(driver.findElement(wd).getSize().getHeight() > 0) {
			return true;
		}
		return false;
	}
	public boolean EnterUsername(String Uname){
		try{
			verifyWebElement(Username);
			driver.findElement(Username).sendKeys(Uname);
			return true;
		}catch(Exception e){

			return false;
		}
	}

	public boolean EnterPassword(String Pwd){
		try{
			verifyWebElement(Password);
			driver.findElement(Password).sendKeys(Pwd);
			return true;
		}catch(Exception e){

			return false;
		}

	}


	public boolean ClickSignIn(){
		try{
			verifyWebElement(SignIn);
			driver.findElement(SignIn).click();
			return true;
		}catch(Exception e){

			return false;
		}
	}
	public int verifyListgroupNumber(){
		List<WebElement> list = driver.findElements(listElements);
		return (Integer) list.size();
	}
	public String verifySecondListValue(){
		List<WebElement> list = driver.findElements(listElements);
		for(int i = 0;i<list.size();i++) {
			if(i == 1) {
				System.out.println(list.get(i).getText());
				return list.get(i).getText();
			}
		}
		return null;
		
	}
	
	public String verifySecondListBadge(){
		return driver.findElement(secondBatch).getText();
	}
	
	public String verifydropdownvalue(){
		return driver.findElement(dropDown).getText();
	}
	
	public void selectdropdownvalue(String dropdown){
		List<WebElement> dropdwn = driver.findElements(dropDownvalue);
		for(WebElement d: dropdwn) {
			if(d.getText().contains(dropdown)) {
				d.click();
			}
		}
	}
	
	public boolean verifyStatusofFirstButton() {
		
		if(driver.findElement(firstButton).isEnabled()){
			return true;
		}
		
		return false;
		
	}
public boolean verifyStatusofSecondButton() {
		
		if(!driver.findElement(secondButton).isEnabled()){
			return true;
		}
		
		return false;
		
	}

public void clickonFifthCaseButton() {
	
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.elementToBeClickable(FifthButton));
	driver.findElement(FifthButton).click();
	
}

public boolean verifyStatusofFifthButton() {
	
	if(!driver.findElement(FifthButton).isEnabled()){
		return true;
	}
	
	return false;
	
}

public boolean verifySuccessMessage() {
	if(driver.findElement(successMessage).isDisplayed()) {
		return true;
	}
	return false;
}

}