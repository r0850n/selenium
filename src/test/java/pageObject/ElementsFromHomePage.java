package pageObject;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.fabric.xmlrpc.base.Array;

public class ElementsFromHomePage {

	@FindBy(id = "tab-hotels")
	private WebElement hotels;
	@FindBy(xpath = "//html/body/div[3]/div[4]/div[1]/div[5]/div[1]/div[1]/div[1]")
	private WebElement populars;

	/*
	 * @FindBy(css="span.price > b") private WebElement
	 */

	public WebElement getPopulars() {
		return populars;
	}

	public WebElement getPopularneKierunki() {
		return hotels;
	}

	public List<WebElement> getAllPopulars() {

		List<WebElement> all = hotels.findElements(By.tagName("li"));
		return all;

	}

	public WebElement find(String name) {

		for (WebElement city : getAllPopulars()) {
			boolean el = city.getText().contains(name);

			if (el) {
				return city;
			}
		}
		return null;

	}

	public List<WebElement> popularne() {

		List<WebElement> all = populars.findElements(By.tagName("li"));

		return all;

	}

	public List<String> allPrices() {

		List<String> ceny = new ArrayList<String>();
		for (WebElement e : getAllPopulars()) {

			WebElement cena = e.findElement(By.cssSelector("span.price > b"));

			ceny.add(cena.getText());
			// System.out.println(ceny.size());
		}
		return ceny;

	}

	public List<Integer> findmin() {
		List<Integer> ceny = new ArrayList<Integer>();
		for (String i : allPrices()) {

			int min = Integer.parseInt(i);

			ceny.add(min);
		}

		return ceny;
	}

	public int minimalna() {

		Integer min = Collections.min(findmin());
		return min;
	}

	public int maxymalna() {

		Integer min = Collections.max(findmin());
		return min;
	}

	public ElementsFromHomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}
}
