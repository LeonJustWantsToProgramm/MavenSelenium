package LetsKodeItTest;

import org.testng.annotations.Test;

import Base.TestBase;
import utilities.DataProviderUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class RadioButtonTest extends TestBase{
		
	  //verbunden mit \src\test\java\\utilities\DataProviderUtil.java
	  @Test (dataProvider = "TestData",dataProviderClass = DataProviderUtil.class)
	  public void RadioButtonBMW(String radioButtonSelection) throws InterruptedException {
		  WebElement radioButton = driver.findElement(By.id(radioButtonSelection));
		  radioButton.click();
		  Thread.sleep(1000);
		  
		  Assert.assertTrue(radioButton.isSelected());
	  }
	  
	/*
	 * @Test (priority = 2) 
	 * public void RadioButtonBenz() throws InterruptedException {
	 * WebElement radioButtonBenz = driver.findElement(By.id("benzradio"));
	 * radioButtonBenz.click();
	 * Thread.sleep(1500);
	 * 
	 * Assert.assertTrue(radioButtonBenz.isSelected()); }
	 * 
	 * 
	 * @Test (priority = 3) 
	 * public void RadioButtonHonda() throws InterruptedException {
	 * WebElement radioButtonHonda = driver.findElement(By.id("hondaradio")); 
	 * radioButtonHonda.click();
	 * Thread.sleep(1500);
	 * 
	 * Assert.assertTrue(radioButtonHonda.isSelected()); }
	 */
}
