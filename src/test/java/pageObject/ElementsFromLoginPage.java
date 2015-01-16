package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsFromLoginPage {
	
	
@FindBy(className="data-panel")	
private WebElement dane;

public WebElement getDane() {
	return dane;
}


public List<WebElement> wszystkieDane(){
	
	List<WebElement> wszystkieDane=dane.findElements(By.tagName("dd"));
	return wszystkieDane;
	
}

public List<String> dane(){
	List<String> dane= new ArrayList<String>();
	for (WebElement e : wszystkieDane()) {

		dane.add(e.getText());
		 System.out.println(e.getText());
	}
	
	return dane;
	
}


public ElementsFromLoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
}
