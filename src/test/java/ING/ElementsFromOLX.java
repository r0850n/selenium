package ING;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class ElementsFromOLX {

	@FindBy(css = "#next-link > span.link.inlblk > span")
	private WebElement next;

	@FindBy(xpath = "//table[@id='offers_table']/tbody/tr[3]/td/table/tbody/tr/td[3]/h3/a/span")
	private WebElement oferta;

	@FindBy(xpath = "//html/body/div[1]/section/div/div/div[2]/div[1]/div[1]/div[2]/div[10]/div[3]/strong")
	private WebElement iloscWyswietlen;

	@FindBy(xpath = "/html/body")
	private WebElement all;
	
	public WebElement getIloscWyswietlen() {
		return iloscWyswietlen;
	}

	public WebElement getOferta() {
		return oferta;
	}

	public WebElement getNext() {
		return next;
	}

	public String getIloscWyswietlenText() {
		return getIloscWyswietlen().getText();

	}

	public List<String> getAllTitles() {
		List<WebElement> elemenst =all.findElements(By.xpath("/html/body")); 

		List<String> results = Lists.transform(elemenst, new ExtractText());
		return results;

	}

	private final class ExtractText implements Function<WebElement, String> {

		@Override
		public String apply(WebElement from) {

			return from.getText();
		}

	}

	public ElementsFromOLX(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
