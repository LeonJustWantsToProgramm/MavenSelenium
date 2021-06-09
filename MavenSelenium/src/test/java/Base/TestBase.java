package Base;

import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class TestBase {
	public static ChromeDriver driver;
	public String baseURL;
	
  @BeforeSuite
  public void setUp() {
	  if(driver == null) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		  driver = new ChromeDriver();
		  baseURL = "https://letskodeit.teachable.com/p/practice";
		  
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  driver.get(baseURL);
	  }
  }


  @AfterSuite
  public void tearDown() {
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	  
	  if (driver != null) {
		  driver.quit();
	  }
  }

}
