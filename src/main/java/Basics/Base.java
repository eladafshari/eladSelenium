package Basics;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties propertiesFile;
	
	
	public static void initializeDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void initializeWait() {
		wait = new WebDriverWait(driver, 20);
	}
	
	public static void openSystem() throws InterruptedException {
		driver.get("https://www.google.com/webhp?authuser=1");
	}
	
	/*public static void initalizePropertiesFile() throws Exception {
		propertiesFile = new Properties();
		FileInputStream file = new FileInputStream
				("E:\\EladWorkspace\\NbaAutomation\\PropertiesFile.properties");
		propertiesFile.load(file);
	}*/
	
	public static void closeDriver() {
		driver.quit();
	}
	
}
