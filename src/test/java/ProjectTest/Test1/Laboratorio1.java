package ProjectTest.Test1;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.junit.jupiter.api.Test;
public class Laboratorio1 {

	@Test
	public void lab11() {
		System.out.println("prueba automatizacion");
	}
	
	@Test
	public void lab1_e1() {
		//System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.pl/index.php");
		
		//driver.close();
	}
	
	@Test
	public void lab1_e2() {
		//System.setProperty("webdriver.gecko.driver", "..\\EducacionIt\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.pl/index.php");
		
		//driver.close();
	}
	
	@Test
	public void lab1_e3() {
		//System.setProperty("webdriver.chrome.driver", "..\\EducacionIt\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.pl/index.php");
		
		driver.getTitle();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.click();
		txtBuscador.sendKeys("summer");
		
		WebElement clickBuscar = driver.findElement(By.name("submit_search"));
		clickBuscar.click();
		
		//driver.close();
	}
	
	
}
