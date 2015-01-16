

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class seleniumGuide {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://book.theautomatedtester.co.uk";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
    driver.get(baseUrl+"/chapter1");
    new Select(driver.findElement(By.id("selecttype"))).selectByVisibleText("Selenium Core");
  assertEquals("Assert that this text is on the page", driver.findElement(By.id("divontheleft")).getText());
   
    driver.findElement(By.id("secondajaxbutton")).click();
    for (int second = 0;; second++) {
    	if (second >= 10) fail("timeout");
    
    	try { if ("To be used after the AJAX section of the book/n"+"I have been added with a timeout".equals(driver.findElement(By.id("html5div")).getText()) != null) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | popupwindow | 30000]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=popupwindow | ]]
  //  assertEquals("Close the Window", driver.findElement(By.id("closepopup")).getText());
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
   // driver.findElement(By.id("secondajaxbutton")).click();
   // assertEquals("", driver.findElement(By.id("secondajax")).getText());
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
