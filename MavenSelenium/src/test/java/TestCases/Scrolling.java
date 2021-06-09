package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Scrolling {

	private ChromeDriver driver;
	private JavascriptExecutor javascriptExecutor;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://usersnap.com/blog/long-scrolling-websites-tips-best-practices/");
	}

	
	@Test
	public void ScrollingTest() {
		
		WebElement strongElement = driver.findElement(By.xpath("//strong[contains(text(),'Wrapping it up.')]"));
		
		javascriptExecutor = (JavascriptExecutor) driver;
		
		javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", strongElement);
		
		
	}
	
	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
