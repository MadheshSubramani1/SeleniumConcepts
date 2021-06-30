package TestNgconcepts;

import org.testng.annotations.Test;

public class DependsOnMethodExample {

	@Test(enabled=true)
	private void Tenth() {

		System.out.println("Studying Tenth class");

	}

	@Test(dependsOnMethods = "Tenth")
	private void Twelth() {

		System.out.println("Studying Twelth class");

	}

	@Test(dependsOnMethods = "Twelth")
	private void college() {

		System.out.println("Studying college");
	}

	@Test
	private void ahd() {
		System.out.println("Studying phd");
	}
	@Test
	private void aah() {
		System.out.println("gettingJOb");
	}
	
	
	//if any depends on method is failed.. the entire test will failed

}
