package LetsKodeItTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FensterWechsel {
	public ChromeDriver driver;
	public String baseURL;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
	
		driver = new ChromeDriver();
		baseURL = "https://letskodeit.teachable.com/p/practice";
		driver.get(baseURL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void FensterWechselTest() {
		WebElement buttonElement = driver.findElement(By.id("openwindow"));
		String MainWindow = driver.getWindowHandle();
		System.out.println(MainWindow);
		buttonElement.click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String window : windowHandles) {
			if(!window.equals(MainWindow)) {
				driver.switchTo().window(window);
				
				WebElement searchField = driver.findElement(By.id("search-courses"));
				searchField.sendKeys("JavaScript");
			
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				driver.close();
				
				break;
			}
		}
		
		driver.switchTo().window(MainWindow);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.id("bmwcheck")).click();
	}
	

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
