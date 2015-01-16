package seleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Pajacyk {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.pah.org.pl/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled2() throws Exception {
	  driver.get(baseUrl+"nasze-dzialania/8/pajacyk");
	    driver.findElement(By.cssSelector("area[title=\"Kliknij w brzuszek\"]")).click();
	    driver.get(baseUrl + "/pajacyk/dziekujemy");
	   
	    String iloscklikniec = driver.findElement(By.xpath("//html/body/div/em")).getText();
    
    System.out.println(iloscklikniec);
  
  }

  
  @Test
public void testName() throws Exception {
	  driver.get(baseUrl);
	for(int i=1;i<10;i++){
		
		testUntitled2();
	}
}
  @After
  public void tearDown() throws Exception {
	  driver.close();
	  Thread.sleep(1000);
    //driver.quit();
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
