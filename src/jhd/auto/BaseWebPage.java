package jhd.auto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseWebPage {
	protected WebDriver driver;

	protected BaseWebPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
