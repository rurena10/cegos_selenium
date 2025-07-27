package pruebas;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import paginas.PaginaInicioPOM;

public class pruebaLogin {
	WebDriver driver;
	@Test
	public void pruebaLoginPom()
	{
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		PaginaInicioPOM objPaginaInicioPom = new PaginaInicioPOM(driver);
		objPaginaInicioPom.singInOk();
		driver.quit();
	}
}
