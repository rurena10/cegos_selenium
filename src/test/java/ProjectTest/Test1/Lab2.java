package ProjectTest.Test1;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lab2 {
	@Test
	public void lab2() 
	{
		WebDriver driver = new ChromeDriver();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");

        WebElement txtEmail = driver.findElement(By.id("email_create"));
        txtEmail.sendKeys("rurena2@cochabamba.bo");

        WebElement btnRegistrar = driver.findElement(By.id("SubmitCreate"));
        btnRegistrar.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));

        WebElement radiobtn = driver.findElement(By.id("id_gender1"));
        radiobtn.click();

        WebElement txtName = driver.findElement(By.id("customer_firstname"));
        txtName.sendKeys("Ricardo");
        
        WebElement txtLastName = driver.findElement(By.name("customer_lastname"));
        txtLastName.sendKeys("Urena");
        
        WebElement txtPass = driver.findElement(By.name("passwd"));
        txtPass.sendKeys("123456");
        
        Select dias = new Select(driver.findElement(By.id("days")));
        dias.selectByValue("24"); 

        Select meses = new Select(driver.findElement(By.id("months")));
        meses.selectByValue("9"); 

        Select anios = new Select(driver.findElement(By.id("years")));
        anios.selectByValue("1983");
        
        WebElement chkNewsletter = driver.findElement(By.id("newsletter"));
        if (!chkNewsletter.isSelected()) {
            chkNewsletter.click();
        }
        
        WebElement btnRegistrarFinal = driver.findElement(By.id("submitAccount"));
        btnRegistrarFinal.click();
        
	}
}
