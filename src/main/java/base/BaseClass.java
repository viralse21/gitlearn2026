package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.out.println("LOG:INFO - Setting up browser");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://freelance-learn-automation.vercel.app/login");
	}
	
	@AfterClass
	public void tearDown()
	{
		System.out.println("LOG:INFO - Closing browser");
		
		driver.quit();
	}

}
