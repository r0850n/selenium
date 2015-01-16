package ING;

import java.util.Iterator;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class KanTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	ElementsFromOLX elementsFromOLX;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	
		baseUrl = "http://olx.pl/oferta/sprzedam-kanarki-kolorowe-CID103-ID7EZjD.html#4b5ddec3fd";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitled2() throws Exception {
		driver.get(baseUrl);
		elementsFromOLX = new ElementsFromOLX(driver);

		// System.out.println(
		// driver.findElement(By.xpath("//html/body/div[1]/section/div/div/div[2]/div[1]/div[1]/div[2]/div[10]/div[3]/strong")).getText());
		// driver.findElement(By.cssSelector("#next-link > span.link.inlblk > span")).click();
		// driver.findElement(By.xpath("//table[@id='offers_table']/tbody/tr[3]/td/table/tbody/tr/td[3]/h3/a/span")).click();
    //System.out.println(elementsFromOLX.getAllTitles());
		
		
		System.out.println(elementsFromOLX.getIloscWyswietlenText());
		elementsFromOLX.getNext();
		elementsFromOLX.getOferta();
	}

	@Test
	public void testName() throws Exception {

		for (int i = 0; i < 100; i++) {

			testUntitled2();

		}
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		Thread.sleep(1000);
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
