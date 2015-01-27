package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class HomePage {

	@FindBy(xpath = "//html/body/div[3]/div[4]/div[1]/div[5]/div[1]/div[1]/div[1]")
	private WebElement populars;
	
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
public List<String> getAllTitles(){
	List<WebElement> elemenst= driver.findElements(By.xpath("//html/body/div[3]/div[4]/div[1]/div[5]/div[1]/div[1]/div[1]"));
	
List<String>results = Lists.transform(elemenst, new ExtractText());
	return results;
	
}


private final class ExtractText implements Function<WebElement, String>{

	@Override
	public String apply(WebElement from) {
		
		return from.getText();
	}
	
}
}
