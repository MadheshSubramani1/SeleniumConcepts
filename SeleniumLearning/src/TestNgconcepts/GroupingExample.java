package TestNgconcepts;

import org.testng.annotations.Test;

public class GroupingExample {

	@Test(groups = { "sanity" })
	public void test1() {
		System.out.println("This is sanity test1");
	}

	@Test(groups = {"regression"})
	public void test2() {
		System.out.println("This is regression test1");
	}

	@Test(groups = { "sanity" })
	public void test3() {
		System.out.println("This is sanity test2");
	}

	@Test(groups = { "regression" })
	public void test4() {
		System.out.println("This is regression test2");
	}

}
