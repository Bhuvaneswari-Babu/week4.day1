package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkwithWindows {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//Click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listWindowHandles= new ArrayList<String>(windowHandles);
		System.out.println(listWindowHandles);
//Find the number of opened windows
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> listWindowHandles1= new ArrayList<String>(windowHandles1);
		System.out.println("Total number of active windows : "+listWindowHandles1.size());
//Close all except this window
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> listWindowHandles2= new ArrayList<String>(windowHandles2);
		for (int i = 1; i < listWindowHandles2.size(); i++) {
		driver.switchTo().window(listWindowHandles2.get(i));
		driver.close();
				}
//Wait for 2 new Windows to open
		driver.switchTo().window(listWindowHandles2.get(0));
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> listWindowHandles3= new ArrayList<String>(windowHandles3);
		System.out.println("Wait for 2 new Windows to open  "+listWindowHandles3.size()+" windows");
		driver.quit();
			}		
}
