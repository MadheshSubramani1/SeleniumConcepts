package TestNgconcepts;

import org.testng.annotations.Test;

public class Use_of_Priority_invocationCount_Enabled {

	@Test(priority = 0,invocationCount = 3)
	public void startTheCar() {

		System.out.println("start the car");

	}

	@Test(priority = 1, enabled = false)
	public void putFirstGear() {

		System.out.println("put first gear");
	}

	@Test(priority = 2)
	public void putSecondGear() {

		System.out.println("put second gear");
	}

	@Test(priority = 3)
	public void putThirdGear() {

		System.out.println("put third gear");
	}

	@Test(priority = 4)
	public void putFourthGear() {

		System.out.println("put fourth gear");
	}

}
