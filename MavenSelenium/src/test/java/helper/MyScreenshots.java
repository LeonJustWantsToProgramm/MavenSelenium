package helper;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class MyScreenshots {

	public static void makeScreenshot (WebDriver driver) {
		
		String screenshotPath = "C:\\Users\\LeonRausch\\eclipse-workspace\\MavenSelenium\\src\\test\\resources\\Screenshots\\" + UUID.randomUUID() + ".png";
		
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(screenshotFile, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
