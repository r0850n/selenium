package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="femail")
	private WebElement user;
	
	
	
	private WebDriver driver;

	By usernameLocator = By.id("femail");
	By passwordLocator = By.id("fpass");
	By buttonToLogin = By.xpath("//html/body/div[3]/form/fieldset[2]/button");

	
	public WebElement getUser() {
		return user;
	}
	 
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;

		if (!"Logowanie do Strefy klienta - eSKY.pl".equals(driver.getTitle())) {
			// Alternatively, we could navigate to the login page, perhaps
			// logging out first
			throw new IllegalStateException("This is not the login page");
		}

	}

	public LoginPage typeUsername(String username) {

		//driver.findElement(usernameLocator).sendKeys(username);
		
		
		getUser().sendKeys(username);
		return this;
	}

	public LoginPage typePassword(String password) {

		driver.findElement(passwordLocator).sendKeys(password);
		return this;
	}

	public HomePage submitLogin() {
		driver.findElement(buttonToLogin).submit();
		return new HomePage(driver);

	}
	 public LoginPage submitLoginExpectingFailure() {
	       
	        driver.findElement(buttonToLogin).submit();

	        // Return a new page object representing the destination. Should the user ever be navigated to the home page after submiting a login with credentials 
	        // expected to fail login, the script will fail when it attempts to instantiate the LoginPage PageObject.
	        return new LoginPage(driver);   
	    }
	 public HomePage loginAs(String username, String password) {
	        // The PageObject methods that enter username, password & submit login have already defined and should not be repeated here.
	        typeUsername(username);
	        typePassword(password);
	        return submitLogin();
	    }
}
