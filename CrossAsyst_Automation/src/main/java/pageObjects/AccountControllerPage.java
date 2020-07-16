package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountControllerPage {
	
	public WebDriver driver;
	
	@FindBy(xpath="//a[text()='Women']")
	private WebElement sectionWomen;
	
	@FindBy(css="a.account")
	private WebElement userAccount;
	
	@FindBy(xpath="//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	@FindBy(xpath="//table[@id=\\\"order-list\\\"]//tbody//tr[1]//td[3]/span")
	private WebElement historyTotalPrice;
	
	public AccountControllerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	public void accountController() {
		sectionWomen.click();
		userAccount.click();
		orderHistory.click();
		historyTotalPrice.getText();
	}
	

}
