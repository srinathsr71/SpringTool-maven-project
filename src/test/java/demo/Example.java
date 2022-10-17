package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {
		public static String address="http://www.tutorialsninja.com/demo/";
		@Test
			public void Register() throws InterruptedException {
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
				driver.get(address);
				driver.manage().window().maximize();
				String beforelogin=driver.getCurrentUrl();
				System.out.println(beforelogin);
				Thread.sleep(3000);
				driver.findElement(By.xpath("//*[@class='list-inline']/li[2]")).click();
				driver.findElement(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']/li[1]/a")).click();
				String after=driver.getCurrentUrl();
				System.out.println(after);
				Thread.sleep(3000);
				driver.findElement(By.id("input-firstname")).sendKeys("charantej");
				driver.findElement(By.id("input-lastname")).sendKeys("kumar");
				driver.findElement(By.id("input-email")).sendKeys("charty@gmail.com");
				driver.findElement(By.id("input-telephone")).sendKeys("9658741256");
				driver.findElement(By.id("input-password")).sendKeys("123456");
				driver.findElement(By.id("input-confirm")).sendKeys("123456");
				WebElement cl=driver.findElement(By.xpath("//*[@class='pull-right']/input"));
							cl.click();
							Thread.sleep(2000);
							driver.findElement(By.xpath("//*[@type='submit']")).click();
							String aftersubmit=driver.getCurrentUrl();
							System.out.println(aftersubmit);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@class='list-inline']/li[2]")).click();
				driver.findElement(By.xpath("//*[@class='dropdown-menu dropdown-menu-right']/li[5]/a")).click();
				String afterlogout=driver.getCurrentUrl();
				System.out.println(afterlogout);
				
				
				
				
				
				
				
				
				
				
				
				
				
			}

		}

