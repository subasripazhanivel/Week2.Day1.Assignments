package week2.day1.assignements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignUp{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.name("firstname")).sendKeys("Subasri");
		driver.findElement(By.name("lastname")).sendKeys("Palanivel");
		driver.findElement(By.name("reg_email__")).sendKeys("subasri123@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("subasri123@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("fb@123");
		
		//birthday dropdown
		WebElement bdayDD=driver.findElement(By.name("birthday_day"));
		Select birthdayDD=new Select(bdayDD);
		birthdayDD.selectByIndex(23);
		
		//Monthdropdown
		WebElement bMonthDD=driver.findElement(By.name("birthday_month"));
		Select birthMonthDD=new Select(bMonthDD);
		birthMonthDD.selectByValue("4");
		
		//Year dropdown
		WebElement bYearDD=driver.findElement(By.name("birthday_year"));
		Select birthYearDD=new Select(bYearDD);
		birthYearDD.selectByVisibleText("1990");
				
		driver.findElement(By.name("sex")).click();
		//driver.findElement(By.name("websubmit")).click();
		
		
		
		
		
		
		
		
		
		
	}

}
