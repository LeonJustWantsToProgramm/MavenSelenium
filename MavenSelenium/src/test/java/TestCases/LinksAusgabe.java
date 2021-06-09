package TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinksAusgabe {
	private ChromeDriver driver;
	private String baseURL;


	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://www.wikipedia.de/";
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(baseURL);
	}
	
	
	@Test
	public void LinksAusgabeTest() {
		List<WebElement> linksListe = driver.findElements(By.tagName("a"));
		
		for(WebElement link : linksListe) {
			System.out.println(link.getAttribute("href"));
		}
	}
	
	@Test
	public void GoogleTest() {
		driver.get("https://www.google.de");
	}
	
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
