package pageObjects;

import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	
	@FindBy(css="a.login")
	private WebElement signIn;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void signIn()
	{
		signIn.click();
	}
	public void printLinkText()
	{
		
	List<WebElement> linksList = driver.findElements(By.tagName("a"));

	List<String> AllLinkText = linksList.stream()
	.filter(ele -> !ele.getText().isEmpty())
	.filter(ele -> !ele.getText().startsWith(" "))
	.map(ele -> ele.getText().trim())
	.collect(Collectors.toList());
	AllLinkText.forEach(ele -> System.out.println(ele));

	}
	
	
}
