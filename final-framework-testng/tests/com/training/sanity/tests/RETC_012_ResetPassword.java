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
import com.training.pom.ResetPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RETC_012_ResetPassword {
	
	private WebDriver driver;
	private String baseUrl;
	private ResetPasswordPOM resetPasswordPOM;
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
		resetPasswordPOM = new ResetPasswordPOM(driver); 
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
	public void resetPassword() {
		resetPasswordPOM.clickSignIn();
		resetPasswordPOM.clickLostPassword();
		resetPasswordPOM.sendEmail("manzoor@gmail.com");
		resetPasswordPOM.clickResetPassword();
		
		screenShot.captureScreenShot("RETC_012_ResetPassword");
		
		String actualMessage= resetPasswordPOM.successMessage();
		String expectedMessage = "A confirmation link has been sent to your email address";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
}
