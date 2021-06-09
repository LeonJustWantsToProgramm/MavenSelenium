package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helper.MyScreenshots;

public class Screenshot {

	private ChromeDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bing.com/");
	}

	@Test
	public void ScreenshotTest() {
		driver.findElement(By.id("sb_form_q")).sendKeys("Testautomatisierung - gewusst wie");
		driver.findElement(By.xpath("//label[@for='sb_form_go']")).click();
		MyScreenshots.makeScreenshot(driver);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
