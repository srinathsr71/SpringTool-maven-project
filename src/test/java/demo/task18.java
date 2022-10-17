package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
public class task18 {
	public static String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(url);
		
		
	}
	@Test(enabled=true,priority=0)
	public void Testcase() throws InterruptedException
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
		
	}
	@Test(enabled=true,priority=1)
	public void testcase1() throws InterruptedException
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@class='oxd-main-menu']/li[1]/a"))).click().build().perform();//Admin
		
		act.moveToElement(driver.findElement(By.xpath("//*[@class='oxd-topbar-body-nav']/ul/li[1]"))).click().build().perform();//user Management
				
		act.moveToElement(driver.findElement(By.linkText("Users"))).click().build().perform();//users
			
		driver.findElement(By.xpath("//*[@class='oxd-form-row']/div/div[1]/div/div[2]/input")).sendKeys("Sara.Tencrady");//username
				
		WebElement wle=driver.findElement(By.xpath("//*[@class='oxd-select-wrapper']"));//user role
	      act.click(wle).build().perform();
	    	act.sendKeys(wle,Keys.ARROW_DOWN).click().build().perform();
		act.sendKeys(wle,Keys.ARROW_DOWN).click().build().perform();
	
		WebElement elem=driver.findElement(By.xpath("//*[@class='oxd-autocomplete-wrapper']/div/input"));//employee name
		act.sendKeys(elem,"Sara Tencrady").click().build().perform();
		
		WebElement elen=driver.findElement(By.xpath("//*[@class='oxd-form-row']/div/div[4]/div/div[2]"));//status
		act.click(elen).build().perform();
		act.sendKeys(elen,Keys.ARROW_DOWN).doubleClick().build().perform();
		
		WebElement sq=driver.findElement(By.xpath("//*[@type='submit']"));//search
		act.moveToElement(sq).doubleClick().build().perform();
	
		driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(0).click();//selecting user
		System.out.println(driver.findElements(By.xpath("//*[@class='oxd-table-card']")).get(0).getText());
	
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).get(0).click();
		driver.findElements(By.xpath("//*[@class='oxd-icon bi-trash']")).get(0).click();//click delete
		driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
	
	}
	
	@Test(enabled=true,priority=2)//logout
	public void Testcase3() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@class='oxd-dropdown-menu']/li[4]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}
	
}