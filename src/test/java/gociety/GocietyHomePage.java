package gociety;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GocietyHomePage {
	private static final String HOME_PAGE = "http://www.gociety.com";
	
	

	private WebDriver driver;
	
	public GocietyHomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public static String getHomePage() {
		return HOME_PAGE;
	}
}
