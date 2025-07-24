package ProjectTest.Test1;

import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.util.Units;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.io.*;
import java.time.Duration;

public class ScreenshotEvidence {

	private WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	
	@Test
	public void testWithEvidence() throws Exception
	{
		WebElement userfield = driver.findElement(By.id("user-name"));
		userfield.sendKeys("standard_user");
		
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		loginBtn.click();
		
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
		takeScreenshot("Login Exitoso","evidencias/login.docx","evidencias/login.png");
	}
	
	public void takeScreenshot(String titulo, String docPath, String imgPath) throws Exception
	{
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File imgFile = new File(imgPath);
        FileUtils.copyFile(screenshot,imgFile);
        
        File docFile = new File(docPath);
        XWPFDocument docx;
        
        if (!docFile.exists())
        {
        	docx = new XWPFDocument();
        }
        else {
        	FileInputStream fis = new FileInputStream(docFile);
        	docx = new XWPFDocument(fis);
        }
        
        XWPFParagraph paragraph = docx.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText(titulo);
        run.setFontSize(13);
        
        InputStream pic = new FileInputStream(imgPath);
        run.addPicture(pic, Document.PICTURE_TYPE_PNG, imgPath, Units.toEMU(500), Units.toEMU(250));
        pic.close();
        
        FileOutputStream out = new FileOutputStream(docPath);
        docx.write(out);
        out.flush();
        out.close();
        docx.close();
	}
	
	@After
	public void tearDown()
	{
		if (driver != null)
		{
			driver.quit();
		}
	}
}
