package seleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.internal.FindsById;
import org.openqa.selenium.internal.FindsByName;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class seleniumGuide {
	private WebDriver driver;
	FirefoxProfile profile;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private LoadElementsFromChapter1 elements;

	@Before
	public void setUp() throws Exception {
	
		baseUrl = "http://book.theautomatedtester.co.uk/chapter1";
		profile=new FirefoxProfile();
		profile.setPreference("browser.startup.homepage", baseUrl);
		driver = new FirefoxDriver(profile);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elements = new LoadElementsFromChapter1(driver);
		//driver.get(baseUrl + "/chapter1");
	}

	@Test
	public void testUntitled2() throws Exception {
		//driver.get(baseUrl + "/chapter1");
		new Select(elements.getSelect()).selectByVisibleText("Selenium Core");
		assertEquals("Assert that this text is on the page", elements
				.getTextOnThePage().getText());

		driver.findElement(By.id("secondajaxbutton")).click();
		for (int second = 0;; second++) {
			if (second >= 10)
				fail("timeout");

			try {
				if ("To be used after the AJAX section of the book/n"
						+ "I have been added with a timeout".equals(driver
								.findElement(By.id("html5div")).getText()) != null)
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

	}

	@Test
	public void testName() throws Exception {
		//driver.get(baseUrl + "/chapter1");

		WebElement element = ((FindsById) driver)
				.findElementById("verifybutton");
System.out.println(element.getAttribute("value"));
		assertTrue(element.isDisplayed());
	}

	@Test
	public void findByName() throws Exception {
		//driver.get(baseUrl + "/chapter1");
		
		WebElement webElement=((FindsByName)driver).findElementByName("selected(1234)");
		
		assertTrue(webElement.isDisplayed());

	}
	@Test
	public void testOptionsfromSelect() throws Exception {
		
		for(WebElement e: elements.alloptions()){
			System.out.println(e.getText());
		}
		
		Select options= new Select(elements.getSelect());
		System.out.println(options.getOptions().get(2).getText());
	}
	
	@Test
	public void testNameRadioButton() throws Exception {
		
		WebElement radio = elements.getRadiobutton();
		System.out.println(radio.getText());
		if(radio.isSelected()){
			
		}
		else{
			radio.click();
			System.out.println("selected");
			System.out.println(radio.getText());
			System.out.println(radio.getAttribute("value"));
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
