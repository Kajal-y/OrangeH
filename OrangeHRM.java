package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrangeHRM{
	WebDriver driver;
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/kajaldriver");
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	@Parameters({"username", "password"})
	public void login(String username, String password) throws InterruptedException {
		WebElement usernameField = driver.findElement(By.id("txtUsername"));
		WebElement passwordField = driver.findElement(By.id("txtPassword"));
		WebElement submit = driver.findElement(By.name("Submit")); 
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		submit.click();
		Thread.sleep(2000);
		driver.close();
	}
}


