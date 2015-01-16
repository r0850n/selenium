package pageObject;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Contains;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matcher;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.matchers.JUnitMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginPageTest {
	private static final String MY_PASSWORD = "aaa";
	private static final String MY_eMAIL_lOGIN = "aaa@o2.pl";
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	private static final String LOGIN_PAGE = "http://www.esky.pl/strefa-klienta/zaloguj-sie";
	private static final String HOME_PAGE = "http://www.esky.pl/";
	LoginPage loginPage;
	WebDriver driver;
    ElementsFromLoginPage elements;
    HomePage homePage;
	private ElementsFromHomePage elementsFromHomePage;
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
	public void testLoginPage() {
		
		login();
		
	//	assertEquals("Robert",elements.wszystkieDane().get(1).getText());
		//System.out.println(elements.wszystkieDane().toString());
		assertTrue(elements.dane().contains("Robert"));
	
  // assertThat(Arrays.asList(elements.dane()), hasItem("Robert"));
    
	}

	
	
	@Test
	public void testName() throws Exception {
		
		login();		
		driver.get(HOME_PAGE);
		elementsFromHomePage= new ElementsFromHomePage(driver);
		
		//List<WebElement> popularne= elementsFromHomePage.getAllPopulars();
		//System.out.println(popularne.size());
		/*assertEquals("Rzym",elementsFromHomePage.popularne().get(6).findElement(By.className("name")).getText());
		for(WebElement e: elementsFromHomePage.popularne()){
			System.out.println(e.findElement(By.className("name")).getText());
		}*/
		//System.out.println(elementsFromHomePage.popularne());
		
		WebElement name = elementsFromHomePage.find("Rzym");
		WebElement price=name.findElement(By.cssSelector("span.price > b"));
		System.out.println(price.getText());
		
		
	}
	 
	@Test 
	public void testName2() throws Exception {
		login();	
		//HomePage homePage = new HomePage(driver);
		driver.get(HOME_PAGE);
		elementsFromHomePage= new ElementsFromHomePage(driver);
		homePage= new HomePage(driver);
		for(WebElement e: elementsFromHomePage.popularne()){
		//	System.out.println(e.findElement(By.className("name")).getText());
		}
		//WebElement cena = elementsFromHomePage.popularne().get(0);
		//System.out.println(cena.findElement(By.cssSelector("span.price > b")).getText());
		//System.out.println(elementsFromHomePage.getAllPopulars().get(0).getText());
		//System.out.println(elementsFromHomePage.minimalna());
		//System.out.println(elementsFromHomePage.maxymalna());
		
		System.out.println(homePage.getAllTitles());
		

	}
	private void login() {
		driver.get(LOGIN_PAGE);
		elements= new ElementsFromLoginPage(driver);
		loginPage = new LoginPage(driver);
		loginPage.loginAs(MY_eMAIL_lOGIN, MY_PASSWORD);
	}
}
