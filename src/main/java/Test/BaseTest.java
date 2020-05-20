package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Basics.Base;
import Basics.Reporter;

public class BaseTest {

	@BeforeSuite
	public static void StartTest () throws InterruptedException {
		Base.initializeDriver();
		Base.initializeWait();
		//Reporter.initializeRepot();
		Base.openSystem();
	}
	
	@Test
	public static void trys () throws InterruptedException {
		System.out.println(Basics.Base.driver.findElement(By.xpath
				("//a[text() = 'Gmail']")).getText());
		System.out.println("sucess");
	}
	
	@AfterSuite
	public static void EndTest() {
		//Reporter.generateReport();
		Base.closeDriver();
	}
}
