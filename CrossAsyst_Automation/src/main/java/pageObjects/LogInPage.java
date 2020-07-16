package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//button[@id='SubmitCreate']")
	private WebElement createAccountBtn;
	
	@FindBy(css="input#email_create")
	private WebElement createAccountEmailAddress;
	@FindBy(css="input#email")
	private WebElement signInEmail;
	
	@FindBy(css="input#passwd")
	private WebElement signInPassword;
	
	@FindBy(xpath="button#SubmitLogin")
	private WebElement submitBtn;
	
	
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	public void loginInWithValidCredentials()
	{
		
		createAccountBtn.click();
		createAccountEmailAddress.sendKeys("testtttpy@test.com");;
		signInEmail.sendKeys("testtttpy@test.com");
		signInPassword.sendKeys("12345");
		submitBtn.click();
		
	}
	public void loginInWithInValidCredentials()
	{
		
	}

}
