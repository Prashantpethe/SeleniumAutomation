package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			WebDriver driver = new ChromeDriver();
			List<WebElement> linksList = driver.findElements(By.tagName("a"));
			 
	         List<String> AllLinkText = linksList.stream()
	.filter(ele -> !ele.getText().isEmpty())
	  .filter(ele -> !ele.getText().startsWith(" "))
	  .map(ele -> ele.getText().trim())
	  .collect(Collectors.toList());
	  AllLinkText.forEach(ele -> System.out.println(ele));
		
		
		
	}

}
