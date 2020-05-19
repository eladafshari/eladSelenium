package Test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Basics.Base;
import Basics.Reporter;

public class BaseTest {

	@BeforeSuite
	public static void StartTest () {
		Base.initializeDriver();
		Base.initializeWait();
		Reporter.initializeRepot();
		Base.openSystem();
	}
	
	@AfterSuite
	public static void EndTest() {
		Reporter.generateReport();
		Base.closeDriver();
	}
}
