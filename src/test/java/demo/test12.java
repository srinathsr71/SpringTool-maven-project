package demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test12 {

	@Test
	public void testcase1()throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		String beforelogin=driver.getTitle();
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		String afterlogin=driver.getTitle();
		if(beforelogin.equals(afterlogin)) {
			driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
			System.out.println("the title is same so i logout");
		}else {
			System.out.print("the title of the page is not same");
		}

		driver.close();
		
	}

	}

