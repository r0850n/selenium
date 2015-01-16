package seleniumTests;


import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class TestWpSeleniumRc {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 5555, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe ", "http://wiadomosci.wp.pl/");
		selenium.start();
	}

	@Test
	public void testUntitled() throws Exception {
		selenium.open("/kat,1329,title,Donald-Tusk-w-nastepnych-wyborach-PO-zremisuje-z-PiS,wid,17075671,wiadomosc.html?ticaid=113e9a&_ticrsn=3");
		selenium.type("name=query", "aaa");
		selenium.click("css=input.sbm");
		selenium.waitForPageToLoad("30000");
		assertEquals("Znaleziono 21 materiałów", selenium.getText("css=strong"));
		assertEquals("", selenium.getText("css=input.sbm"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
