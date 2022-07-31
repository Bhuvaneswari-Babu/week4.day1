package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceCustomerService {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Enter the username as " ramkumar.ramaiah@testleaf.com "
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
//Enter the password as " Password$123 "
		driver.findElement(By.id("password")).sendKeys("Password$123");
//click on the login button
		driver.findElement(By.id("Login")).click();
//click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
//Switch to the next window using Windowhandles
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindowHandles=new ArrayList<String>(windowHandles);
		String secondWindowHandle = listWindowHandles.get(1);
	    driver.switchTo().window(secondWindowHandle);
//click on the confirm button in the redirecting page
	    driver.findElement(By.xpath("//button[text()='Confirm']")).click();
//Get the title
	    String title = driver.getTitle();
	    System.out.println(title);
//Get back to the parent window		
	    String firstWindowHandle = listWindowHandles.get(0);
	    driver.switchTo().window(firstWindowHandle);
//close the browser
	    driver.quit();
	}

}
