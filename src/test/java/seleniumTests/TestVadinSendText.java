package seleniumTests;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestVadinSendText {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	private LoadElementsFromVaadinApp elementsFromVaadinApp;
	private WebElement textArea;
	private WebElement buttonToComboBox;
	private List<WebElement> options;
	private WebElement send;
	private WebElement textAreaToTypeEmailOrSms;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8752/Vaadinjpa/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		elementsFromVaadinApp = new LoadElementsFromVaadinApp(driver);
		driver.get(baseUrl);
    // prepareElements();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	@Test
	public void testUntitled() throws Exception {

		textArea = elementsFromVaadinApp.getTextArea();
		textArea.clear();
		textArea.sendKeys("przykladowy tekst3 dziala!!!");

		elementsFromVaadinApp.getButtonToComboBox().click();

		elementsFromVaadinApp.alloptions().get(1).click();

		elementsFromVaadinApp.getSendButton().click();
		for (int second = 0;; second++) {
			if (second >= 30)
				fail("timeout");
			try {
				if (elementsFromVaadinApp.getEmailArea().isDisplayed())
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		elementsFromVaadinApp.getEmailArea().clear();
		elementsFromVaadinApp.getEmailArea().sendKeys("222 222 222");
		elementsFromVaadinApp.getSendButton().click();
		for (int second = 0;; second++) {
			if (second >= 30)
				fail("timeout");
			try {
				if (elementsFromVaadinApp.selectedRecordInTable(0).get(2)
						.isDisplayed())
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		/*assertEquals("przykladowy tekst3 dziala!!!", elementsFromVaadinApp
				.selectedRecordInTable(5).get(2).getText());*/
	}

	@Test
	public void testUntitled2() throws Exception {
		driver.get(baseUrl + "/Vaadinjpa/");
		driver.findElement(
				By.xpath("//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div[7]/div/div"))
				.click();

		textArea = elementsFromVaadinApp.getTextArea();
		textArea.clear();
		textArea.sendKeys("sprawdz");

		elementsFromVaadinApp.alloptions().get(1).click();

		elementsFromVaadinApp.getSendButton().click();
		elementsFromVaadinApp.alloptions().get(1).click();
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {

				if (elementsFromVaadinApp.getEmailArea().isDisplayed())
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		elementsFromVaadinApp.getEmailArea().clear();
		elementsFromVaadinApp.getEmailArea().sendKeys("aaa@wp.pl");
		elementsFromVaadinApp.getSendButton().click();
		/*
		 * assertEquals( "sprawdz", driver.findElement( By.xpath(
		 * "//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div[15]/div/div[2]/div/table/tbody/tr[28]/td[3]/div"
		 * )) .getText());
		 */

	}

	@Test
	public void dropAndDragTest() throws Exception {
		driver.get(baseUrl + "/Vaadinjpa/");
		Actions builder = new Actions(driver);
		WebElement body = elementsFromVaadinApp.getBody();
		assertTrue(body.isDisplayed());
		Action contextClick = builder.contextClick(body).build();
		contextClick.perform();

	}

	@Test
	public void allOptionsTest() throws Exception {

		driver.get(baseUrl + "/Vaadinjpa/");
		elementsFromVaadinApp.getButtonToComboBox().click();
		for (WebElement e : elementsFromVaadinApp.alloptions()) {
             
			if (e.getText().equals("sms")) {
				System.out.println("jest " + e.getText());
                 
			} else {
				System.out.println("nie ma takiego" +e.getText() );
			}
		}

	}
@Test
public void test3() throws Exception {
	 
	textArea = elementsFromVaadinApp.getTextArea();
	textArea.clear();
	textArea.sendKeys("przykladowy tekst3 dziala!!!");

	elementsFromVaadinApp.getButtonToComboBox().click();
	elementsFromVaadinApp.alloptions().get(1).click();
	//elementsFromVaadinApp.getButtonToComboBox().click();
	//assertTrue(elementsFromVaadinApp.alloptions().get(1).isSelected());
	//elementsFromVaadinApp.alloptions().get(0).click();
	elementsFromVaadinApp.getSendButton().click();
	for (int second = 0;; second++) {
		if (second >= 10)
			fail("timeout");
		try {

			if (elementsFromVaadinApp.getEmailArea().isDisplayed())
				break;
		} catch (Exception e) {
		}
		Thread.sleep(1000);
	}
	
}

	@Test
	public void testMultipleSelect() throws Exception {
		driver.get(baseUrl + "/Vaadinjpa/");
		elementsFromVaadinApp.getButtonToComboBox().click();

		options = elementsFromVaadinApp.alloptions();
		Actions builder = new Actions(driver);
		Action multipleSelect = builder.keyDown(Keys.SHIFT)
				.click(options.get(0)).click(options.get(2)).build();

		multipleSelect.perform();

	}

	@Test
	public void tabletest() throws Exception {
		driver.get(baseUrl + "/Vaadinjpa/");
		elementsFromVaadinApp.getButtonToComboBox().click();
		System.out.println(elementsFromVaadinApp.selectedRecordInTable(0)
				.get(0).getText());

	}

	@Test
	public void testName() throws Exception {

		driver.get("http://book.theautomatedtester.co.uk/multi-select.html");
		Actions builder = new Actions(driver);
		WebElement select = driver.findElement(By
				.id("selectWithMultipleEqualsMultiple"));
		List<WebElement> options = select.findElements(By.tagName("option"));

		Action multipleSelect = builder.keyDown(Keys.SHIFT)
				.click(options.get(0)).click(options.get(2)).build();
		multipleSelect.perform();
	}

	@Test
	public void dropCanwas() throws Exception {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://www.theautomatedtester.co.uk/demo1.html");
		Actions builder = new Actions(driver);
		WebElement canvas = driver.findElement(By.id("tutorial"));
		Action dragAndDrop = builder.clickAndHold(canvas)
				.moveByOffset(-40, -60).moveByOffset(20, 20)
				.moveByOffset(100, 150).release(canvas).build();
		dragAndDrop.perform();
	}

	
	@Test
	public void split() throws Exception {
		for(int i=0; i<=4;i++){
			
			testUntitled();
		}
		
	}
	@Test
	  public void testUntitled3() throws Exception {
	    driver.get(baseUrl + "/Vaadinjpa/");
	    driver.findElement(By.xpath("//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div/textarea")).clear();
	    driver.findElement(By.xpath("//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div/textarea")).sendKeys("test");
	    // ERROR: Caught exception [Error: unknown strategy [class] for locator [class=v-filterselect-button]]
	    driver.findElement(By.cssSelector("span.v-button-wrap")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("222222222");
	  }
	@Test
	public void select() throws Exception {
		driver.get("http://book.theautomatedtester.co.uk/chapter1");
		
		
		Select select=new Select(elementsFromVaadinApp.getSelect());
		
		assertFalse(select.isMultiple());
		System.out.println(select.getOptions().size());
		select.selectByVisibleText("Selenium RC");
		assertEquals("Selenium RC", select.getFirstSelectedOption().getText());
	}
	
	@Test
	public void testWithImplicitWait()
	{
	 //Go to the Demo AJAX Application
	 WebDriver driver = new FirefoxDriver();
	 driver.get("http://dl.dropbox.com/u/55228056/AjaxDemo.html");

	 //Set the Implicit Wait time Out to 10 Seconds
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	 try {
	 //Get link for Page 4 and click on it
	 WebElement page4button = driver.findElement(By.linkText("Page 4"));
	 page4button.click();

	 //Get an element with id page4 and verify it's text
	/* WebElement message = driver.findElement(By.id("#page4"));
	 assertTrue(message.getText().contains("Nunc nibh tortor"));
*/
	 } catch (NoSuchElementException e) {
	 fail("Element not found!!");
	 e.printStackTrace();
	 } finally {
	 driver.close();
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

	private void prepareElements() {

		textArea = elementsFromVaadinApp.getTextArea();
		buttonToComboBox = elementsFromVaadinApp.getButtonToComboBox();
		options = elementsFromVaadinApp.alloptions();
		send = elementsFromVaadinApp.getSendButton();
		textAreaToTypeEmailOrSms = elementsFromVaadinApp.getEmailArea();

	}
}
