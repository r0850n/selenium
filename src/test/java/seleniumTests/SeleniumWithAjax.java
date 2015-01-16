package seleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWithAjax {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
 
  private WebElement loadajax;
  private WebElement ajax;
  private LoadElementsFromChapter1 loadElements;

  @Before
  public void setUp() throws Exception {
	  
	  
    driver = new FirefoxDriver();
    baseUrl = "http://book.theautomatedtester.co.uk/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
   loadElements= new LoadElementsFromChapter1(driver);   
  }

  @Test
  public void testUntitled2() throws Exception {
    driver.get(baseUrl + "/chapter1");
    loadajax=loadElements.getLoadajax();
    loadajax.click();
    
    ajax=loadElements.getAjax();
   // driver.findElement(By.id("loadajax")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try {
    		//if (isElementPresent(By.cssSelector("#ajaxdiv > p"))) 	
    			if (ajax.isDisplayed()) 	
    	break; } 
    	
    	catch (Exception e) {}
    	Thread.sleep(1000);
    }

    try {
      assertEquals("The following text has been loaded from another page on this site. "
      		+ "It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter", 
    		  ajax.getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
  }
  
  @Test
public void asonchronous() throws Exception {
	  driver.get(baseUrl + "/chapter1");
	    loadajax=loadElements.getLoadajax();
	    loadajax.click();
	    
	   // ajax=loadElements.getAjax();
	    
	  WebElement myDynamicElement= (new WebDriverWait(driver, 10).
			  until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#ajaxdiv > p")))); 
	 
	  
	  assertEquals("The following text has been loaded from another page on this site. "
	      		+ "It has been loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter", 
	    		 myDynamicElement.getText());
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
