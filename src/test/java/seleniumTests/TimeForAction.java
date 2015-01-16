package seleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TimeForAction {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://book.theautomatedtester.co.uk/chapter1";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl );
    driver.findElement(By.id("multiplewindow")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | popupwindow | 30000]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=popupwindow | ]]
    assertEquals("Text within the pop up window", driver.findElement(By.id("popuptext")).getText());
    driver.findElement(By.id("closepopup")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("(//div[@id='multiplewindow'])[2]")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp | popupwindow2 | 30000]]
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=popupwindow2 | ]]
    assertEquals("Text within the pop up window", driver.findElement(By.id("popuptext")).getText());
    driver.findElement(By.id("closepopup")).click();
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
