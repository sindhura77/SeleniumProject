package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPOM {
	
private WebDriver driver; 
	
	public ResetPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="sign-in")
	private WebElement signIn;
	
	@FindBy(xpath="//a[@href='http://realestatem1.upskills.in/wp-login.php?action=lostpassword']")
	private WebElement lostPassword;
	
	@FindBy(id="user_login")
	private WebElement email;
	
	@FindBy(xpath="//input[@value='Reset Password']")
	private WebElement resetPassword;
	
	@FindBy(xpath="//p")
	private WebElement successMessage;
	
	
	public void clickSignIn()	{
		this.signIn.click();
	}
	
	public void clickLostPassword()	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", this.lostPassword);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void clickResetPassword()	{
		this.resetPassword.click();
	}
	
	public String successMessage()	{
		return this.successMessage.getText();
	}
	
	
}
