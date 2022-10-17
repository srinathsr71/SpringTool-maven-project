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


public class task879 {
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
					
					WebElement uname=driver.findElement(By.xpath("//*[@placeholder='Username']"));
					if(uname.isEnabled())
					{
						uname.sendKeys("Admin");
					
					}
					if(uname.isDisplayed()) 
					{

						driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
						driver.findElement(By.xpath("//*[@type='password']")).sendKeys("admin123");	
						driver.findElement(By.xpath("//*[@type='submit']")).click();
					}
				//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					
					
				
	}
		
				@AfterTest
				public void AT() {
					//Thread.sleep(3000);

					driver.findElement(By.xpath("//*[@class='oxd-userdropdown']")).click();
					driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
					driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
					driver.close();
				}
	}

