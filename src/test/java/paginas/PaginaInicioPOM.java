package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaginaInicioPOM {

	WebDriver driver;
	
	By username = By.id("user-name");
	By password = By.id("password");
	By BtnLogin = By.id("login-button");
	
	public PaginaInicioPOM(WebDriver driver)
	{
		this.driver = driver ;
	}

	public void singInOk()
	{
		driver.findElement(username).sendKeys("standard_user");
		driver.findElement(password).sendKeys("secret_sauce");
		driver.findElement(BtnLogin).click();
	}
}
