package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class task {

	
		public static String tour="https://demo.guru99.com/test/newtours/";
		WebDriver guru;
		String K;
		
		@BeforeTest
		public void beforetest() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			guru =new ChromeDriver();
			guru.get(tour);
			Thread.sleep(3000);
			K=guru.getTitle();
			 System.out.println(K);
		}
		@Test(enabled=true,priority=0)
		public void Testcase1() throws InterruptedException
		{
			
			
			 		guru.findElement(By.name("userName")).sendKeys("user");
			guru.findElement(By.name("password")).sendKeys("user");
			guru.findElement(By.name("submit")).click();
			Thread.sleep(2000);
		}
		@Test(enabled=true,priority=1)
		public void Testcase2() {
			
			guru.findElement(By.linkText("REGISTER")).click();
			guru.findElement(By.name("firstName")).sendKeys("madhavi");
			guru.findElement(By.name("lastName")).sendKeys("latha");
			guru.findElement(By.name("phone")).sendKeys("961128903");
			guru.findElement(By.name("userName")).sendKeys("madhavilatha23@gmail.com");
			guru.findElement(By.name("email")).sendKeys("madhavilatha23");
			guru.findElement(By.name("password")).sendKeys("madhu@123");
			guru.findElement(By.name("confirmPassword")).sendKeys("madhu@123");
			guru.findElement(By.name("submit")).click();
		}
			
		@AfterTest(enabled=true)
		public void aftertest() throws InterruptedException
		{
			
			System.out.println(guru.getCurrentUrl());
			
			guru.close();
			
	}
	}

