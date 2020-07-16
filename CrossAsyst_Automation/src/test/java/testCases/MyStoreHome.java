package testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import resources.Base;


public class MyStoreHome extends Base{
	
	
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
	}
	@Test
	public void createAccount() {
		driver.get(prop.getProperty("url"));
		HomePage hP= new HomePage(driver);
		hP.getsignIn().click();
		log.info("Clicked on SignIn");
		
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}

}
