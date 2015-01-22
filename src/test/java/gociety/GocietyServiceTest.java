package gociety;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.HomePage;

public class GocietyServiceTest {

	private StringBuffer verificationErrors = new StringBuffer();
	private WebDriver driver;
	private GocietyHomePage homePage;
	private GocietyLoginPage loginPage;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

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

	@Test
	public void startHomePageTest() {
		goToHomePage();
		assertTrue(driver.getTitle().equals("Gociety"));
	}
	
	@Test
	public void startLoginPageTest(){
		goToLoginPage();
		
		assertTrue(driver.getTitle().equals("Gociety"));
	}

	@Test
	public void badlLoginTest() throws Exception {
		goToLoginPage();
		loginPage= new GocietyLoginPage(driver);
		loginPage.loginAs("aaa@wp.pl", "aaa");
		
		System.out.println(loginPage.getErrorLogin().getText()); 
		assertTrue(loginPage.getErrorLogin().isDisplayed());
	}
	public GocietyHomePage goToHomePage() {

		driver.get(GocietyHomePage.getHomePage());

		return homePage;

	}
	
	public GocietyLoginPage goToLoginPage(){
		
		driver.get(GocietyLoginPage.getLoginPage());
		return loginPage;
	}
}
