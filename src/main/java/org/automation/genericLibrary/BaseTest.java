package org.automation.genericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

	public WebDriver driver;
	static WebDriver listnersDriver;
	public DataUtility dataUtility = new DataUtility();
	HomePage home_Page;
	
	
	@Parameters("Browser")
	@BeforeClass(alwaysRun=true)
	public void launchBrowser(@Optional("Chrome")String browserName) throws IOException {
		
		if(browserName.equals("Chrome")){
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("Edge")){
			driver = new EdgeDriver();
		}
		
		listnersDriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(dataUtility.getDataFromProperties("url"));
	}
	@BeforeMethod(alwaysRun=true)
	public void performLogin() throws EncryptedDocumentException, IOException {
		
		home_Page = new HomePage(driver);
		home_Page.getLogin().click();
		
		LoginPage login_Page = new LoginPage(driver);
		login_Page.getEmailTextField().sendKeys(dataUtility.getDataFromProperties("email"));
		login_Page.getPasswordTextField().sendKeys(dataUtility.getDataFromProperties("pwd"));
		login_Page.getLoginButton().click();
	}
	
	@AfterMethod(alwaysRun=true)
	public void performLogout() {
		driver.findElement(By.linkText("Log out")).click();	
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowser() {
		driver.close();
	}
}
