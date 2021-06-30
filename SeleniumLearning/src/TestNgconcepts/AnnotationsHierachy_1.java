package TestNgconcepts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AnnotationsHierachy_1 {

	@Test
	public void Test_2() {
		System.out.println("This is method-2");
	}

	@Test
	public void Test_1() {
		System.out.println("This is method-1");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("This is After Method");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is after class");
	}

	@BeforeTest
	public void beforeTest() {

		System.out.println("This is Before test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("This is after test");
	}

	@BeforeSuite
	public void beforeSuite() {

		System.out.println("This is Before suite");
	}

	@AfterSuite
	public void afterSuite() {

		System.out.println("This is after suite");
	}

}
