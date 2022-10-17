package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class task23 {
	
	  WebDriver driver;
	 @BeforeTest
	 public void beforetest() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			
			Thread.sleep(5000);
	 }
			@Test
			public void Testcase2() throws InterruptedException {
				
			//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElement(By.name("username")).sendKeys("Admin");
				driver.findElement(By.name("password")).sendKeys("admin123");
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				Thread.sleep(2000);	
}
			
			@Test
			public void Testcase3() throws InterruptedException {
				driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]/a")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(11).click();
				driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(11).click();
				driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(11).click();
				driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
								
				
			}
			@AfterTest
			public void AT() throws InterruptedException {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
				driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
				//driver.close();
			}
}