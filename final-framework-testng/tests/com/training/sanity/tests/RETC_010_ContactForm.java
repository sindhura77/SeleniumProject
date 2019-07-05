package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ContactFormPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_010_ContactForm {
	
	private WebDriver driver;
	private String baseUrl;
	private ContactFormPOM contactFormPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		contactFormPOM = new ContactFormPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void contactFormTest() {
		
		contactFormPOM.clickBlog();
		contactFormPOM.clickDropUsALine();
		contactFormPOM.sendUserName("Sindhu");
		contactFormPOM.sendEmail("sindhu123@gmail.com");
		contactFormPOM.sendSubject("Apartments");
		contactFormPOM.sendMessage("Looking for Apartments");
		contactFormPOM.clickSend();
		
		screenShot.captureScreenShot("RETC_010_ContactForm");
		
		String actualMessage = contactFormPOM.successMessage();
		String expectedMessage = "Thank you for your message. It has been sent.";
		Assert.assertEquals(actualMessage, expectedMessage);
	}
	

}
