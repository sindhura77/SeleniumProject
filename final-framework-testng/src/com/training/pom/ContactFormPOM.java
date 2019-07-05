package com.training.pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactFormPOM {
	
private WebDriver driver; 
	
	public ContactFormPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[@href='http://realestatem1.upskills.in/blog/'])[1]")
	private WebElement blog;
	
	@FindBy(xpath="//a[@href='/contact/']")
	private WebElement dropUsALine;
	
	@FindBy(name="name")
	private WebElement userName;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(name="id:comments")
	private WebElement message;
	
	@FindBy(xpath="//input[@value='Send']")
	private WebElement send;
	
	@FindBy(xpath="//div[@class='wpcf7-response-output wpcf7-display-none wpcf7-mail-sent-ng']")
	private WebElement successMessage;
	
	
	public void clickBlog()	{
		this.blog.click();
	}
	
	public void clickDropUsALine()	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", this.dropUsALine);
		
	}
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendEmail(String email) {
		this.email.clear();
		this.email.sendKeys(email);
	}
	
	public void sendSubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);
	}
	
	public void sendMessage(String message) {
		this.message.clear();
		this.message.sendKeys(message);
	}
	
	
	public void clickSend()	{
		this.send.click();
	}
	
	public String successMessage()	{
		return this.successMessage.getText();
	}
	

}
