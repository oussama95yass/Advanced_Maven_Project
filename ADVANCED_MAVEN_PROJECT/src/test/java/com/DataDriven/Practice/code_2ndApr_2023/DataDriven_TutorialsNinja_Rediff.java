package com.DataDriven.Practice.code_2ndApr_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DataDriven_TutorialsNinja_Rediff {

	
WebDriver driver;
	

	@Test( priority= 1, dataProvider = "dataForTN", dataProviderClass = Separate_Data_Provider.class)
	public void loginNinjaTest(String username, String password) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	 
	}
	
	@Test( priority = 2, dataProvider = "dataForRediff", dataProviderClass = Separate_Data_Provider.class)
	public void loginRediffTest(String username, String password) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.id("login1")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("signinbtn")).click();
	 
	}
	
}
