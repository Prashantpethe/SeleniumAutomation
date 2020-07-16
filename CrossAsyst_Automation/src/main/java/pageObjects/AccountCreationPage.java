package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {
	public WebDriver driver;
	
	@FindBy(css="input#id_gender1")
	private WebElement title;
	@FindBy(css="input#customer_firstname")
	private WebElement firstName;
	@FindBy(css="input#customer_lastname")
	private WebElement lastName;
	@FindBy(css="input#passwd")
	private WebElement password;
	@FindBy(css="select#days")
	private WebElement dOBDays;
	@FindBy(css="select#months")
	private WebElement dOBMonth;
	@FindBy(css="select#years")
	private WebElement dOBYear;
	@FindBy(css="input#firstname")
	private WebElement addressFirstName;
	@FindBy(css="input#lastname")
	private WebElement addressLastName;
	@FindBy(css="input#address1")
	private WebElement address;
	@FindBy(css="input#city")
	private WebElement city;
	@FindBy(css="select#id_state")
	private WebElement state;
	@FindBy(css="input#postcode")
	private WebElement postalcode;
	@FindBy(css="select#id_country")
	private WebElement country;
	@FindBy(css="input#phone_mobile")
	private WebElement mobilePhoneNo;
	@FindBy(css="input#alias")
	private WebElement addressAlias;
	@FindBy(css="button#submitAccount")
	private WebElement registerBtn;
	
	public AccountCreationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void accountCreation()
	{
		title.click();
		firstName.sendKeys("test");
		lastName.sendKeys("test");
		password.sendKeys("1234");
		dOBDays.click();
		dOBMonth.click();
		dOBYear.click();
		address.sendKeys("test");
		city.click();
		state.click();
		postalcode.click();
		country.click();
		mobilePhoneNo.sendKeys("test");
		addressAlias.sendKeys("test");
		registerBtn.click();
		
	}
	
}
