package EduIT;


import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Laboratoria_1 {
	
	@Test @Ignore
	public void Lab1_Test() 
	{
		System.out.print("Hola mundo de automatizacion!");		
	}
	@Test
	public void Lab1_E2() 
	{
		System.setProperty("webdriver.gecko.driver",
				"..\\EduIT\\Drivers\\geckodriver.exe");		
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		
		WebElement txtBusqueda = driver.findElement(By.id("search_query_top"));
		txtBusqueda.click();
		txtBusqueda.sendKeys("Blouse");
		txtBusqueda.sendKeys(Keys.ENTER);
		driver.close();
	}
	@Test @Ignore
	public void Lab1_E1() 
	{
		System.setProperty("webdriver.chrome.driver" ,
				"..\\EduIT\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("http://automationpractice.pl/index.php");
		driver.manage().window().maximize();
		
		WebElement txtBusqueda = driver.findElement(By.id("search_query_top"));
		txtBusqueda.click();
		txtBusqueda.sendKeys("Blouse");
		txtBusqueda.sendKeys(Keys.ENTER);
		driver.close();
	}
}
