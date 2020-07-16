package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



import java.util.stream.Collectors;


public class WomenStorePage {

	public WebDriver driver;
	By productName = By.xpath("//img[@title='Blouse']");
	By quickView = By.xpath("(//span[text()='Quick view'])[2]");
	By quantity = By.cssSelector("input#quantity_wanted");
	By addToCart = By.xpath("(//button/span[text()='Add to cart'])[last()]");
	By proceedToCheckOut = By.xpath("//a[@title='Proceed to checkout']");
	By itemPrice = By.cssSelector("span#our_price_display");
	By itemPriceExcludingShipping = By.cssSelector("span#ajax_block_cart_total");
	//By itemTotalPrice = By.xpath("//strong[contains(text(),'Total shipping')]//parent::div//preceding-sibling::div/span");
	By itemTotalPrice = By.xpath("(//span[@class='ajax_block_cart_total'])");
//	 //strong[contains(text(),'Total shipping')]//parent::div//preceding-sibling::div/span
	public WomenStorePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getproductName()
	{
		return driver.findElement(productName);
	}
	public WebElement getQuickView() {
		return driver.findElement(quickView);
	}
	public WebElement getQuantity() {
		return driver.findElement(quantity);
	}
	public WebElement getAddToCart() {
		return driver.findElement(addToCart);
	}
	public WebElement getProceedToCheckOut() {
		return driver.findElement(proceedToCheckOut);
	}
	public WebElement getitemPrice() {
		return driver.findElement(itemPrice);
	}
	public WebElement getItemPriceExcludingShipping()
	{
		return driver.findElement(itemPriceExcludingShipping);
	}
	public WebElement getItemTotalPrice()
	{
		return driver.findElement(itemTotalPrice);
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
