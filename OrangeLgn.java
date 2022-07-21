package pack;



import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeLgn  {
	
	WebDriver driver;
	String baseURL = "https://opensource-demo.orangehrmlive.com/";
	
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/usr/bin/kajaldriver");
		driver = new ChromeDriver();
		driver.get(baseURL);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
	}
	
	@Test
	public void getTitle() throws InterruptedException {
		List <WebElement> links = driver.findElements(By.xpath("//div[@id='social-icons']/a"));
		for(int i=0;i<links.size();i++) {
			driver.navigate().to(links.get(i).getAttribute("href"));
			String title = driver.getTitle();
			System.out.println(title);
			driver.navigate().back();
		}
	}


@Test(dataProvider="DP")
public void login(String username, String password) throws InterruptedException {
	WebElement usernameField = driver.findElement(By.id("txtUsername"));
	WebElement passwordField = driver.findElement(By.id("txtPassword"));
	WebElement submit = driver.findElement(By.name("Submit")); 
	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
	submit.click();
	driver.findElement(By.partialLinkText("Welcome")).click();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Logout")).click();
}

@DataProvider(name="DP")
public Object[][] dataObject(){
	return new Object[][]{
			{"Admin", "admin123"},{"Kajal", "kajal123"}, {"Sonal", "sonal123"}, {"Supriya", "12345678"}
	};
}}



