package week2.day1.assignements;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLeadAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Launching URL in chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");

		// Maximizing browser window
		driver.manage().window().maximize();

		// Wait Management

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Login Page
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		// verify whether home page is loaded
		String title = "My Home | opentaps CRM";
		String hometitle = driver.getTitle();

		if (!title.equals(hometitle)) {

			System.out.println("Test leaf home page is not  loaded");
		} else {

			System.out.println("Test leaf home page is loaded.Please proceed with Lead creation");
		}

		// Create lead

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		// verify whether Create Lead page is loaded
		String createTitle = "Create Lead | opentaps CRM";
		String createLeadTitle = driver.getTitle();
		// System.out.println(createLeadTitle);

		if (createTitle.equals(createLeadTitle)) {
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Bhargav pvt ltd");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Bhargav");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Mithran");
			WebElement dsDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
			Select dataScrDpDn = new Select(dsDropDown);
			dataScrDpDn.selectByIndex(2);
			WebElement mrkDropDown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
			Select mrkDrpDwn = new Select(mrkDropDown);
			mrkDrpDwn.selectByVisibleText("Demo Marketing Campaign");
			driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Baiyoo");
			driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("kaju");
			driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr.");
			driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("08/19/88");
			driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("2000000");
			WebElement ccyDropDown = driver.findElement(By.id("createLeadForm_currencyUomId"));
			Select ccyDrpDwn = new Select(ccyDropDown);
			ccyDrpDwn.selectByValue("INR");
			WebElement indDropDown = driver.findElement(By.id("createLeadForm_industryEnumId"));
			Select indDrpDwn = new Select(indDropDown);
			indDrpDwn.selectByValue("IND_SOFTWARE");
			driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("234");
			driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("300000");
			WebElement ownerDrDwn = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
			Select ownerDpDn = new Select(ownerDrDwn);
			ownerDpDn.selectByVisibleText("Partnership");
			driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("XXX");
			driver.findElement(By.id("createLeadForm_description")).sendKeys("All is well");
			driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("Time is very precious");
			// Contact information
			WebElement countryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
			countryCode.clear();
			countryCode.sendKeys("5");
			driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
			driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("044");
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("73588345052");
			driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Suba");
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("suba90@testleaf.com");
			driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("https://login.testleaf/test");
			// Primary address section
			driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Bhargav");
			driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Baiyoo");
			driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Address1");
			driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Address2");
			driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
			driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600213");
			driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")).sendKeys("TN");
			WebElement cndropdown = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
			Select contryDD = new Select(cndropdown);
			contryDD.selectByValue("IDN");
			driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("914325");
			// Print first name
			String text = driver.findElement(By.id("createLeadForm_firstName")).getAttribute("value");
			System.out.println("First Name : " + text);
			driver.findElement(By.className("smallSubmit")).click();
		} else {
			System.out.println("Create lead page is not loaded");
		}
		String title3 = "View Lead | opentaps CRM";
		String viewTitle = driver.getTitle();
		if (title3.equals(viewTitle)) {

			System.out.println("Lead creation is successful.View Lead screen is loaded");

		} else {
			System.out.println("View lead screen is not loaded.Check Lead creation");
		}
		
		//driver.close();

	}

}
