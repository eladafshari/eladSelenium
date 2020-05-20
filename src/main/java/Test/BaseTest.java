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
		Basics.Base.driver.findElement(By.cssSelector
				("a[href = 'https://www.sport5.co.il/html/pages/GamesResults.html']")).click();
		Basics.Base.wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector(".winnerbtn")));
		System.out.println(Basics.Base.driver.findElement(By.cssSelector
				(".winnerbtn")).getText());
		System.out.println("sucess");
	}
	
	@AfterSuite
	public static void EndTest() {
		//Reporter.generateReport();
		Base.closeDriver();
	}
}
