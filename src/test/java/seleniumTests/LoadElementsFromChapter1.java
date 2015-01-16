package seleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadElementsFromChapter1 {
	// elements by id--------------------------------------------------------
	@FindBy(id = "loadajax")
	private WebElement loadajax;

	@FindBy(id = "divontheleft")
	private WebElement textOnThePage;

	@FindBy(id = "selecttype")
	private WebElement select;
	
	@FindBy(id = "radiobutton")
	private WebElement radiobutton;

	


	// elements by cssSelectors-------------------------------------------------
	@FindBy(css = "#ajaxdiv > p")
	private WebElement ajax;

	public WebElement getSelect() {
		return select;
	}

	public WebElement getTextOnThePage() {
		return textOnThePage;
	}

	public WebElement getAjax() {
		return ajax;
	}

	public WebElement getLoadajax() {
		return loadajax;
	}
	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public LoadElementsFromChapter1(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public List<WebElement> alloptions(){
		
		List<WebElement> options = select.findElements(By.cssSelector("option"));
		
		return options;
		
	}
}
