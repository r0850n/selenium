import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import components.Tabela;


public class Vadtest extends TestCase {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8752/Vaadinjpa/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testVaadinJpa() throws Exception {
	    driver.get(baseUrl + "/Vaadinjpa/");
	    driver.findElement(By.xpath("//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div[7]/div/div")).click();
	    driver.findElement(textArea()).clear();
	    driver.findElement(textArea()).sendKeys("test");
	    driver.findElement(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td")).click();
	    driver.findElement(By.cssSelector("span.v-button-wrap")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("aaa@wp.pl");
	    
	    
		assertTrue(isElementPresent(textArea()));
	    
	  }
	  @Test
	  public void testUntitled2() throws Exception {
	    driver.get(baseUrl + "/Vaadinjpa/");
	    driver.findElement(textArea()).clear();
	    driver.findElement(textArea()).sendKeys("fcgdf");
	    driver.findElement(By.xpath("//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div[7]/div/div")).click();
	    driver.findElement(By.cssSelector("div.v-filterselect.v-filterselect-focus > div.v-filterselect-button")).click();
	    driver.findElement(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[4]/td")).click();
	    driver.findElement(By.xpath("//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div[7]/div/div")).click();
	    driver.findElement(textArea()).clear();
	    driver.findElement(textArea()).sendKeys("ojnblkj");
	    driver.findElement(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td")).click();
	    driver.findElement(By.cssSelector("span.v-button-wrap")).click();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("aaa@wp.pl");
	  }

	private By textArea() {
		return By.cssSelector("textarea.v-textarea.v-textarea-focus");
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
