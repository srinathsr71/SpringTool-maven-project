package demo;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class taskwindowhandle {
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
			public void Testcase2() {
				
			//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
				driver.findElement(By.name("username")).sendKeys("Admin");
				driver.findElement(By.name("password")).sendKeys("admin123");
				driver.findElement(By.xpath("//*[@type='submit']")).click();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
}
			
			@Test
			public void Testcase3() {
		
				driver.getWindowHandle();
				driver.switchTo().newWindow(WindowType.TAB);
				driver.navigate().to("https://www.youtube.com");		
			}
			
			@Test
			public void Testcase4() {
		
				driver.getWindowHandle();
				driver.switchTo().newWindow(WindowType.WINDOW);
				driver.navigate().to("https://www.facebook.com");		
			}
			
			
		
}

