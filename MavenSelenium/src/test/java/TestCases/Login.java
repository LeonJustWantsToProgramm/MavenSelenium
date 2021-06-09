package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
	private ChromeDriver driver;
	private By usernameLocator = By.id("username");
	private By passwordLocator = By.id("password");
	private By username2Locator = By.id("formly_1_input_username_0");
	private By loginButtonLocator = By.cssSelector(".btn.btn-danger");
	public Login(ChromeDriver driver) {
		this.driver = driver;
	}
	
	public void typeUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public void typePassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public void typeUsername2(String username2) {
		driver.findElement(username2Locator).sendKeys(username2);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButtonLocator).click();
	}
}
