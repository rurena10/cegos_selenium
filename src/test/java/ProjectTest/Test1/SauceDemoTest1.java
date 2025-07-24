package ProjectTest.Test1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SauceDemoTest1 {

	private WebDriver driver;
	
	@BeforeClass
	public void Setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	
	@Test (priority = 1)
	public void LoginExitoso()
	{
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//1er assert debe cambiar a inventario
		String currentURL = driver.getCurrentUrl();
		Assert.assertTrue(currentURL.contains("inventory.html"),"La URL no contiene 'inventory.html' URL actual: " + currentURL);
		
		//2do assert algun elemento del inventario aparece
		boolean isInventoryDisplayed = driver.findElement(By.className("inventory_list")).isDisplayed();
		Assert.assertTrue(isInventoryDisplayed, "La lista de Inventario no esta visible");;
	}
	
	@Test (priority = 2)
	public void LoginFallido()
	{
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("otro-usuario");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//assert mensaje de error
		String errorMessage = driver.findElement(By.cssSelector(".error-message-container > h3:nth-child(1)")).getText();
		Assert.assertTrue(errorMessage.contains("Epic sadface"),"Mensaje de error inesperado: " + errorMessage);
	}
	
	@AfterClass
	public void tearDown()
	{
		if (driver != null)
		{
			driver.quit();
		}
	}

}
