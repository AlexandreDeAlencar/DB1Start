package com.db1.db1start;

import org.junit.Test;

import com.sun.tools.javac.util.Assert;

public class AppTest {
	
	@Test
	public void showNumber5() {
		Application application = new Application();
		Integer expected=5;
		Integer response = application.soma(2,3);
		Assert.assertEquals(expected, response);
	}
	
	@Test
	public void showNumber8() {
		Application application = new Application();
		Integer expected=5;
		Integer response = application.soma(2,3);
		Assert.assertEquals(expected, response);
	}
	
}
