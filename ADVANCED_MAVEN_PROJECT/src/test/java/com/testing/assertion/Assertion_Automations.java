package com.testing.assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_Automations {
	
	public WebDriver driver;
	public SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
	
	}
	@Test(priority = 1)
	public void verifyNinjaPolicyWarningMessageTest() {
		
        String actualWarningMessage = driver.findElement(By.xpath("//div[@class = 'alert alert-danger alert-dismissible']")).getText();
        String expectedWarningMessage = "Warning: You must agree to the Privacy Policy!";
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "warning message is not getting displayed");
        softassert.assertAll();
	}
	
	@Test(priority = 2)
	public void verifyNinjaFirstNameWarningMessageTest() {
        String actualWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-firstname']/following-sibling::div[1]")).getText();
        String expectedWarningMessage = "First Name must be between 1 and 32 characters!";
        softassert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "warning message is not getting displayed");
        softassert.assertAll();
	}
	
	@Test(priority = 3)
	public void verifyNinjaLastNameWarningMessageTest() {
		softassert.assertTrue(driver.findElement(By.xpath("//input[@id = 'input-lastname']/following-sibling::div[1]")).isDisplayed());
		
		softassert.assertAll();
	}
	
	@Test(priority = 4)
	public void verifyNinjaEmailWarningMessageTest() {
		String actualWarningMessage = driver.findElement(By.xpath("//input[@id = 'input-email']/following-sibling::div[1]")).getText();
		String expectedWarningMessage = "E-Mail Address does not appear to be valid!";
		softassert.assertEquals(expectedWarningMessage, actualWarningMessage);
		softassert.assertAll();
	}
	
	@Test(priority = 5)
	public void verifyNinjaTelephoneWarningMessageTest() {
		softassert.assertFalse(!driver.findElement(By.xpath("//input[@id = 'input-telephone']/following-sibling::div[1]")).isDisplayed());
		softassert.assertAll();
	
	}
	
	@Test(priority = 6)
	public void verifyNinjaPasswordWarningMessageTest() {
		softassert.assertTrue(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div[1]")).isDisplayed());
		
		softassert.assertAll();
	}
}
