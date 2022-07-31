package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
//Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();	
//Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();
//Click on contacts Button		
		driver.findElement(By.linkText("Contacts")).click();
//Click on Merge Contacts using Xpath Locator 		 
		driver.findElement(By.linkText("Merge Contacts")).click();		
//Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindowHandles=new ArrayList<String>(windowHandles);
		String secondWindowHandle = listWindowHandles.get(1);
	    driver.switchTo().window(secondWindowHandle);
//Click on First Resulting Contact
	    driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
//Click on Widget of To Contact
	    String firstWindowHandle = listWindowHandles.get(0);
	    driver.switchTo().window(firstWindowHandle);
	    driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
	    Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindowHandles1=new ArrayList<String>(windowHandles1);
		String newWindow = listWindowHandles1.get(1);
	    driver.switchTo().window(newWindow);
//Click on Second Resulting Contact	    
	   driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click();
//Click on Merge button using Xpath Locator 
	   driver.switchTo().window(firstWindowHandle);
	   driver.findElement(By.linkText("Merge")).click();
//Accept the Alert	   
	   Alert alert = driver.switchTo().alert();
       alert.accept();
   String title = driver.getTitle();
    System.out.println(title);	   
	   	}

}
