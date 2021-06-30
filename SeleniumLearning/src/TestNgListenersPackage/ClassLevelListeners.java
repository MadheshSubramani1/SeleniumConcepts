package TestNgListenersPackage;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNgListenersPackage.TestNGListeners.class)

public class ClassLevelListeners {

	@Test
	public void method() {

		Assert.assertTrue(false);

	}

}
