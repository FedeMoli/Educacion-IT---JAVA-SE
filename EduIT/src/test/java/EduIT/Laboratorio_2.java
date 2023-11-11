package EduIT;

import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Laboratorio_2 {
	
	@Test
	public void lab2_E1() 
	{
		String url="http://www.automationpractice.pl/index.php";
		System.setProperty("webdriver.chrome.driver" ,
				"..\\EduIT\\Drivers\\chromedriver.exe"); 		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
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
		
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		driver.close();
				
	}

}
