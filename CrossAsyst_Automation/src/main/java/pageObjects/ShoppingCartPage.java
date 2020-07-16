package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	
	public static WebDriver driver;
	By proceedToCheckOut = By.xpath("//p[contains(@class, 'cart_navigation') and contains(@class, 'clearfix')]/a/span");
	By addressProceedTocheckOut = By.xpath("//button[@name='processAddress']");
	By shippingProceedToCheckOut = By.xpath("//button[@name='processCarrier']");
	//By termsOFService = By.xpath("//div[@id='uniform-cgv']");
	By termsOFService = By.cssSelector("input#cgv");
	By paymentOption = By.cssSelector("a.bankwire");
	By orderConfirmation = By.xpath("//p[@id='cart_navigation']//button/span");
	static By summaryTotalProducts = By.xpath("//td[@id=\"total_product\"]");
	static By summaryTotalShipping = By.xpath("//td[@id=\"total_shipping\"]");
	static By summaryTotal = By.xpath("//td[@id=\"total_price_without_tax\"]");
	//static By summaryTax = By.xpath("//td[@class=\"cart_total\"]//span[@class='price']");
	static By summaryTax = By.xpath("//td[@id=\"total_tax\"]");
	//static By totalPrice = By.xpath("//td[@id='total_price_without_tax']");
	By paymentTotalPrice = By.xpath("//span[@id='total_price']");
	By beforConfirmOderTotalPrice = By.xpath("//span[@id='amount']");
	
	
	By totalPrice = By.xpath("(//div[contains(@class,'layer_cart_row')])[3]");
	
	public WebElement gettotalPrice()
	{
		return driver.findElement(totalPrice);
	}
	
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public WebElement getproceedToCheckOut()
	{
		return driver.findElement(proceedToCheckOut);
	}
	public WebElement getaddressProceedTocheckOut()
	{
		return driver.findElement(addressProceedTocheckOut);
	}
	public WebElement getShippingProceedToCheckOut()
	{
		return driver.findElement(shippingProceedToCheckOut);
	}
	public WebElement getTermsOFService()
	{
		return driver.findElement(termsOFService);
	}
	public WebElement getpaymentOption()
	{
		return driver.findElement(paymentOption);
	}
	public WebElement getOrderConfirmation()
	{
		return driver.findElement(orderConfirmation);
	}
	public static WebElement getTotalPrice()
	{
		return driver.findElement(summaryTotal);
	}
	public WebElement getPaymentTotalPrice()
	{
		return driver.findElement(paymentTotalPrice);
	}
	public WebElement getBeforConfirmOderTotalPrice()
	{
		return driver.findElement(beforConfirmOderTotalPrice);
		
	}
	public static WebElement getsummaryTotalProducts()
	{
		return driver.findElement(summaryTotalProducts);
	}
	public static WebElement getsummaryTotalShipping()
	{
		return driver.findElement(summaryTotalShipping);
	}
	public static WebElement getsummaryTax()
	{
		return driver.findElement(summaryTax);
	}
			
	
	
	

}
