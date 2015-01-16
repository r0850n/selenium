package seleniumTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoadElementsFromVaadinApp {
	// elements by id--------------------------------------------------------
	@FindBy(id = "loadajax")
	private WebElement loadajax;

	@FindBy(id = "divontheleft")
	private WebElement textOnThePage;

	@FindBy(id = "selecttype")
	private WebElement select;

	@FindBy(id = "VAADIN_COMBOBOX_OPTIONLIST")
	private WebElement comboBox;

	// elements by cssSelectors-------------------------------------------------
	@FindBy(css = "#ajaxdiv > p")
	private WebElement ajax;

	@FindBy(css = "textarea")
	private WebElement textArea;
	// byxpath--------------------------------------------------------------------
	
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement emailArea;

	@FindBy(tagName = "body")
	private WebElement body;

	@FindBy(xpath = "//div[@id='Vaadinjpa-416572120']/div/div[2]/div/div/div/div/div/div/div/div[7]/div/div")
	private WebElement clickButtonOnComboBox;

	@FindBy(xpath = "//span[@class='v-button-wrap']")
	private WebElement sendButton;

	// --------------------------------------------------------------------------
	@FindBy(className = "v-filterselect-button")
	private WebElement buttonToComboBox;
	
	@FindBy(className="v-table-body")
	private WebElement table;

	// -----------------------------------------------------------------------
	
	
	public WebElement getTable() {
		return table;
	}

	public LoadElementsFromVaadinApp(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getBody() {
		return body;
	}

	public WebElement getEmailArea() {
		return emailArea;
	}

	public WebElement getTextArea() {
		return textArea;
	}

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

	
	public WebElement getComboBox() {
		return comboBox;
	}

	public WebElement getClickButtonOnComboBox() {
		return clickButtonOnComboBox;
	}

	public WebElement getButtonToComboBox() {
		return buttonToComboBox;
	}

	public WebElement getSendButton() {
		return sendButton;
	}

	public List<WebElement> alloptions() {

		List<WebElement> options = comboBox.findElements(By.tagName("tr"));
		return options;

	}
	
	public List<WebElement> allRecordInTable(){
		
		List<WebElement> records = table.findElements(By.tagName("tr"));
		return records;
		
	}
	
public List<WebElement> selectedRecordInTable(int index){
	
	WebElement tableRow=allRecordInTable().get(index);
		
	      List<WebElement> selectedElements = tableRow.findElements(By.tagName("td"));
	    return selectedElements;
	
	}

}
