package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WaitImplExpl {
	ChromeDriver driver;
	String baseURL;
	private WebDriverWait wait;
	
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://the-internet.herokuapp.com/dynamic_loading/1";
		wait = new WebDriverWait(driver, 6);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	
	@Test
	public void testWaitImplExpl() {
		driver.findElement(By.cssSelector("#start button")).click();
		
		String textFinish = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish"))).getText();
		System.out.println(textFinish);
	}

	@AfterClass
	public void tearDown() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
