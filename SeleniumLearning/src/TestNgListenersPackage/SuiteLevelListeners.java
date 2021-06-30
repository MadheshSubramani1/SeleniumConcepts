package TestNgListenersPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SuiteLevelListeners {

	@Test
	public void method1() {

		Assert.assertTrue(true);

	}

	@Test
	public void method2() {

		Assert.assertTrue(false);

	}
}
