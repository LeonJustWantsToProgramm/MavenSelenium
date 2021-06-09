package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestCases.Login;

public class testLoginBase {
	private ChromeDriver driver;
	private Login login;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\Executables\\chromedriver.exe");
		driver = new ChromeDriver();
		login = new Login(driver);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.way2automation.com/angularjs-protractor/registeration/#/login");
	}
	
	@Test
	public void testLogin() {
		login.typeUsername("angular");
		login.typePassword("password");
		login.typeUsername2("Leon");
		
		login.clickLoginButton();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.close();
	}
}
