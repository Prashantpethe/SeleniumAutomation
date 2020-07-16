package testCases;

import static org.junit.Assert.assertEquals;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.*;

import pageObjects.AccountControllerPage;
import pageObjects.AccountCreationPage;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.ShoppingCartPage;
import pageObjects.WomenStorePage;
import resources.Base;


public class CreateAccount extends Base {

	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	
	private static double iPrice;
	private static double expectedPrice;
	private static double Price;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	@Test(enabled=false)
	public void CreateAccount() throws InterruptedException
	{
		HomePage hP= new HomePage(driver);
		hP.getsignIn().click();
		Thread.sleep(1000);
		LogInPage lP = new LogInPage(driver);
		lP.getcreateAccountEmailAddress().sendKeys(prop.getProperty("email"));
		lP.getcreateAccountBtn().click();
		AccountCreationPage aC = new AccountCreationPage(driver);
		aC.getTitle().click();
		aC.getFirstName().sendKeys(prop.getProperty("firstName"));
		aC.getLastName().sendKeys(prop.getProperty("firstName"));
		aC.getPassword().sendKeys(prop.getProperty("password"));
		System.out.println("reached here");
		WebElement days=aC.getdOBDays();
		System.out.println("reached her");
		Thread.sleep(1000);
		Select sday = new Select(days);
		sday.selectByValue("19");
		WebElement month=aC.getdOBMonth();
		Select smonth = new Select(month);
		smonth.selectByValue("1");
		WebElement year=aC.getdOBYear();
		Select syear = new Select(year);
		syear.selectByValue("2002");
		aC.getAddress().sendKeys(prop.getProperty("firstName"));
		aC.getCity().sendKeys(prop.getProperty("firstName"));
		WebElement state = aC.getState();
		Select sState = new Select(state);
		sState.selectByIndex(1);
		aC.getPostalCode().sendKeys("00000");
		aC.getCountry();
		aC.getMobilePhoneNo().sendKeys(prop.getProperty("mobNo"));
		aC.getAddressAlias().clear();
		aC.getAddressAlias().sendKeys(prop.getProperty("firstName"));
		aC.getregisterBtn().click();
		Thread.sleep(1000);
		System.out.println("reached her");
	}
//	@Test(priority=1)
//	public void signIn() throws InterruptedException
//	{
//		HomePage hP= new HomePage(driver);
//		hP.getsignIn().click();
//		Thread.sleep(1000);
//		LogInPage lP = new LogInPage(driver);
//		lP.getSignInEmail().sendKeys(prop.getProperty("email"));
//		lP.getSignInPassword().sendKeys(prop.getProperty("password"));
//		lP.getsubmitBtn().click();
//		System.out.println("Login Successfully");
//		Thread.sleep(1000);
//	}
	@Test(priority=2)
	public static double addProductToCart() throws InterruptedException
	{
		driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
		//AccountControllerPage aCP = new AccountControllerPage(driver);
		//aCP.getsectionWomen().click();
		WomenStorePage wSP = new WomenStorePage(driver);
		WebElement productName=wSP.getproductName();
		//WebElement quickView=wSP.getQuickView();
		Actions a =new Actions(driver);
		a.moveToElement(productName).perform();
		Thread.sleep(1000);
		wSP.getQuickView().click();
		driver.switchTo().frame(0);
		String price=wSP.getitemPrice().getText();
		price=price.substring(1);
		iPrice = Double.parseDouble(price);
			
		WebElement quantity=wSP.getQuantity();
		
		/* Explicit Wait for Quantity*/
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(quantity));
		quantity.clear();
		quantity.sendKeys(prop.getProperty("quantity")); //Enter Quantity
		wSP.getAddToCart().click();
		driver.switchTo().defaultContent();//Switched back to default content*/
		
		expectedPrice = iPrice * Double.parseDouble((prop.getProperty("quantity")));
		System.out.print("Expected Price is"+expectedPrice);
		Thread.sleep(2000);
		WebElement e=   driver.findElement(By.xpath("//span[@class='ajax_block_cart_total']"));
	      String s=e.getText();
	      System.out.println("TestPrice"+s);
		return Price;
		
		
//		System.out.println("Testvalue"+wSP.getItemTotalPrice().getText());
//		System.out.println("TextContext"+wSP.getItemPriceExcludingShipping().getAttribute("textContent"));
//		System.out.println("innertext"+wSP.getItemPriceExcludingShipping().getAttribute("innertext"));
//		
//		//String s = wSP.getItemPriceExcludingShipping().getAttribute("textContent");
//		System.out.println("textcontent"+s);
//		System.out.println("tt");
//		System.out.println("GetAttrvalue"+wSP.getItemTotalPrice().getAttribute("value"));
//		System.out.println("r3");
//		wSP.getProceedToCheckOut().click();
//		System.out.println("added");
//		Thread.sleep(3000);
//		return expectedPrice;
	}
//	@Test(priority=3)
//	public static double checkOutProcess() throws InterruptedException
//	{
//		ShoppingCartPage sCP = new ShoppingCartPage(driver);
//		CreateAccount.addProductToCart();
//		String summaryTotalProduct=sCP.getsummaryTotalProducts().getText();
//		String summaryTotalShipping=sCP.getsummaryTotalShipping().getText();
//		String summaryTax=sCP.getsummaryTax().getText();
//		String totalPrice=sCP.getTotalPrice().getText();
//		String paymentTotalPrice=sCP.getPaymentTotalPrice().getText();
//		
//		summaryTotalProduct=summaryTotalProduct.substring(1);
//		summaryTotalShipping=summaryTotalShipping.substring(1);
//		summaryTax=summaryTax.substring(1);
//		totalPrice=totalPrice.substring(1);
//		paymentTotalPrice=paymentTotalPrice.substring(1);
//		
//		double sTotalProduct = Double.parseDouble(summaryTotalProduct);
//		double sTotalShipping = Double.parseDouble(summaryTotalShipping);
//		double sSummaryTax = Double.parseDouble(summaryTax);
//		double sTotalPrice = Double.parseDouble(totalPrice);
//		double sPaymentTotalPrice = Double.parseDouble(paymentTotalPrice);
//		
//		 Price = sTotalProduct+sTotalShipping+sSummaryTax;
//		
//		Assert.assertEquals(Price,sPaymentTotalPrice,1);
//		
//		//Assert.assertEquals(CreateAccount.addProductToCart(), sCP.getTotalPrice().getText());
//		//System.out.println("pricee"+sCP.getTotalPrice().getText());
//		sCP.getproceedToCheckOut().click();
//	
//		sCP.getaddressProceedTocheckOut().click();
//		Thread.sleep(1000);
//		sCP.getTermsOFService().click();
//		//Thread.sleep(3000);
//		sCP.getShippingProceedToCheckOut().click();
//		//System.out.println("pr"+sCP.getPaymentTotalPrice().getText());
//		sCP.getpaymentOption().click();
//		//System.out.println("prr"+sCP.getBeforConfirmOderTotalPrice().getText());
//		sCP.getOrderConfirmation();
//		
//		return Price;
//	}
//	@Test(priority=4)
//	public static void verifyOrderHistory()
//	{
//		AccountControllerPage aCP = new AccountControllerPage(driver);
//		aCP.getuserAccount().click();
//		aCP.getorderHistory().click();	
//		System.out.println("TT"+aCP.getHistoryTotalPrice().getText());
//	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
	
}
