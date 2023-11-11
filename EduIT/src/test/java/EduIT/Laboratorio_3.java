package EduIT;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Laboratorio_3 {
	WebDriver driver;
	String url="http://www.automationpractice.pl/index.php";
	
	
	@BeforeSuite
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver" ,
				"..\\EduIT\\Drivers\\chromedriver.exe"); 		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
    }
	
    @BeforeTest
    public void irUrl()
    {
		driver.get(url);
    }
    
    @BeforeClass
    public void maxVentana()
    {
		driver.manage().window().maximize();
    }
    
    @Test (priority = 1,description = "fisrt Test")
    public void registrarUsuario()
    {
    	WebElement classIngresar = driver.findElement(By.xpath("//a[@class='login'][contains(.,'Sign in')]"));
		classIngresar.click();
		WebElement textIngresarMail = driver.findElement(By.id("email_create"));
		textIngresarMail.clear();
		textIngresarMail.sendKeys("pruebaAutomatiza"+Math.random()+"@correo.com");
		textIngresarMail.sendKeys(Keys.ENTER);
		
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(20));
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id,'gender1')]")));
		WebElement btn_Garder = driver.findElement(By.xpath("//input[contains(@id,'gender1')]"));
		btn_Garder.click();
		
		WebElement textNombre = driver.findElement(By.id("customer_firstname"));
		textNombre.sendKeys("Federico");
		WebElement textApellido = driver.findElement(By.id("customer_lastname"));
		textApellido.sendKeys("Educacion IT");
		WebElement textPassword = driver.findElement(By.id("passwd"));
		textPassword.sendKeys("12345");
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue("8");
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByValue("6");
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1999");
		
		//WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		//btnRegister.click();
		//System.out.println(driver.getCurrentUrl());
		Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation", driver.getCurrentUrl());
		//Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=my-account", driver.getCurrentUrl());

    }
    @Test(priority = 2,description = "Second Test")
    public void pruebaTest()
    {
    	assertTrue(true);
    }
    @AfterMethod
    public void capturaPantalla() throws Exception{
        File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File("..\\EduIT\\Evidencias\\pantalla.png"));
    }
    
    @AfterClass
    public void finPrueba()
    {
    	System.out.println("fin de prueba");
    }
    @AfterTest
    public void cierraNavegador()
    {
        driver.close();
    }
    @AfterSuite
    public void finSuite()
    {
    	System.out.println("fin de Suite");

    }

}
