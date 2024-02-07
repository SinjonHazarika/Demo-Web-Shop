package org.automation.testScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.LoginPage;
import org.automation.elementRepository.RegisterPage;
import org.automation.genericLibrary.BaseTest;
import org.automation.genericLibrary.DataUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Register_TestCase extends BaseTest {

	
	@Test 
	public void Register() throws EncryptedDocumentException, IOException {
		DataUtility data_Utility = new DataUtility();
		LoginPage login_Page = new LoginPage(driver);
		login_Page.getLogoutButton().click();
		
		
		//Step 1 : Click on Register button and verify
		HomePage home_Page = new HomePage(driver);
		home_Page.getRegister().click();
		
		String expectedTitleRegister="Demo Web Shop. Register";
		String actualTitleRegister = driver.getTitle();
		Assert.assertEquals(actualTitleRegister, expectedTitleRegister, "Registration page title does not match");
		Reporter.log("Registration page title displayed");
		
		
		//Step 2 : Enter Data
		RegisterPage register_Page = new RegisterPage(driver);
		register_Page.getMaleRadioButton().click();
		register_Page.getFirstNameTextField().sendKeys(data_Utility.getDataFromExcel("RegisterTestData", 1, 0));
		register_Page.getLastNameTextField().sendKeys(data_Utility.getDataFromExcel("RegisterTestData", 1, 1));
		register_Page.getEmailTextField().sendKeys(data_Utility.getDataFromExcel("RegisterTestData", 1, 2));
		register_Page.getPasswordTextField().sendKeys(data_Utility.getDataFromExcel("RegisterTestData", 1, 3));
		register_Page.getcPasswordTextField().sendKeys(data_Utility.getDataFromExcel("RegisterTestData", 1, 4));
		
		register_Page.getRegisterButton().click();
		
		
		//Step 3 : Verify if registration is successful
		String expected ="Your registration completed";
		String actual = register_Page.getRegisterationText().getText();
		Assert.assertEquals(actual, expected, " Registration failed");
		Reporter.log("Registration completed");
		
		
	}
}
