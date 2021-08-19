package week2.day1.assignements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("UserFirstName")).sendKeys("Subasri");
		driver.findElement(By.name("UserLastName")).sendKeys("Pazhanivel");
		driver.findElement(By.name("UserEmail")).sendKeys("Subasri123@gmail.com");
		driver.findElement(By.name("CompanyName")).sendKeys("Bhargav pvt ltd");
		driver.findElement(By.name("UserPhone")).sendKeys("46765776876");

		// jobtilte dropdown
		WebElement jTDD = driver.findElement(By.name("UserTitle"));
		Select jobTitleDD = new Select(jTDD);
		jobTitleDD.selectByVisibleText("Marketing / PR Manager");

		// Employee dropdown
		WebElement empDD = driver.findElement(By.name("CompanyEmployees"));
		Select employeeDD = new Select(empDD);
		employeeDD.selectByValue("250");

		// Country dropdown
		WebElement cntryDD = driver.findElement(By.name("CompanyCountry"));
		Select countryDD = new Select(cntryDD);
		countryDD.selectByValue("KR");

	}

}
