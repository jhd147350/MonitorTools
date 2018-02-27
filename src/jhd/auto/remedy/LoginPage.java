package jhd.auto.remedy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jhd.auto.BaseWebPage;

public class LoginPage extends BaseWebPage {

	private String url = "https://chinabluemix.itsm.unisysedge.cn/arsys/shared/login.jsp";

	@FindBy(id = "username-id")
	private WebElement usernameInput;
	
	@FindBy(id = "pwd-id")
	private WebElement passwordInput;
	
	@FindBy(id = "loginText")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver.get(url);
	}

	public void login(String username, String password) {

		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}

}
