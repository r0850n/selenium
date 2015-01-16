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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.hamcrest.Matchers.*;

import com.thoughtworks.selenium.DefaultSelenium;




public class VaadinJpatest2 extends TestCase {
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();
	  private DefaultSelenium     selenium;
	  @FindBy(id="email")
	  private WebElement emailField;

	  @Before
	  public void setUp() throws Exception {
	    selenium = new DefaultSelenium("localhost", 5555, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe ", "http://localhost:8752/Vaadinjpa/");
	    selenium.start();
		 driver = new FirefoxDriver();
	    baseUrl = "http://localhost:8752/Vaadinjpa/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testVaadinJpa() throws Exception {
	    driver.get(baseUrl );//+ "/Vaadinjpa/");
	    selenium.open("/Vaadinjpa/");
	    WebElement page=driver.findElement(By.xpath("//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div[7]/div/div"));
	    page.click();      
	    WebElement textArea = driver.findElement(textArea());
	    textArea.clear();
        textArea.sendKeys("test");
	   WebElement comboBox=  driver.findElement(By.xpath("//div[@id='VAADIN_COMBOBOX_OPTIONLIST']/div/div[2]/table/tbody/tr[2]/td"));
          
	    comboBox.click();
	   WebElement sendbutton= driver.findElement(By.cssSelector("span.v-button-wrap"));
	     System.out.println(sendbutton.getText());
	   sendbutton.click();
	   
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).clear();
	    driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("aaa@wp.pl");
	   // driver.findElement(By.id("__gwt_historyFrame"));
	   // System.out.println(page);
	assertTrue(isElementPresent(textArea()));
	assertEquals("Wprowadź wiadomość", selenium.getText("css=div.v-captiontext"));
	Object string="Wprowadź wiadomość";
	//assertThat(string,equas(selenium.getText("css=div.v-captiontext")));
	assertEquals("Send", sendbutton.getText());
	  }

	private By textArea() {
		return By.cssSelector("textarea.v-textarea.v-textarea-focus");
	}

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    selenium.stop();
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
