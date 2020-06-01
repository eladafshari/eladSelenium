package Basics;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {

	public static String capture (WebDriver driver, String name) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String screenNamePath = "ScreenShots\\" + name + ".png";
		String dir = "test_result\\" + screenNamePath;
		File dest = new File(dir);
		
		try {
			FileUtils.copyFile(source, dest);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return screenNamePath;
	}
}
