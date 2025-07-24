package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaginaInicioPageFactory
{
	public class pagePF{
		WebDriver driver;
		
		@FindBy(id = "user-name")
		WebElement usernameInput;
		
		@FindBy(id = "password")
		WebElement passwordInput;
		
		@FindBy(id = "login-button")
		WebElement loginBtn;
		
		public pagePF (WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		public void enterUsername(String username) {
			usernameInput.sendKeys(username);
		}
		
		public void enterPass(String password) {
			passwordInput.sendKeys(password);
		}
		
		public void clickLogin() {
			loginBtn.click();
		}
	}
}
