package LetsKodeItTest;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.TestBase;

public class SelectBoxTest extends TestBase {
	List<WebElement> listeAutos;
	Select selectAutos;
	
	@BeforeClass
	public void setUpBeforeClass() {
		WebElement selectElement = driver.findElement(By.id("carselect"));
		selectAutos = new Select(selectElement);
		
		listeAutos = selectAutos.getOptions();
	}
	
	@Test (priority = 2)
	public void DropDownBMW() throws InterruptedException {
		selectAutos.selectByValue("bmw");
		Thread.sleep(1000);
		Assert.assertTrue(listeAutos.get(0).isSelected());
  }
	
	@Test (priority = 1)
	public void DropDownBenz() throws InterruptedException {
		selectAutos.selectByValue("benz");
		Thread.sleep(1000);
		Assert.assertTrue(listeAutos.get(1).isSelected());
  }
	
	@Test (priority = 3)
	public void DropDownHonda() throws InterruptedException {
		selectAutos.selectByValue("honda");
		Thread.sleep(1000);
		Assert.assertTrue(listeAutos.get(2).isSelected());
  }
	

}
