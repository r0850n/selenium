package android;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AndroidTest {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		
		DesiredCapabilities c= new DesiredCapabilities();
//		c.setCapability("opera.product",OperaProduct.MOBILE);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
