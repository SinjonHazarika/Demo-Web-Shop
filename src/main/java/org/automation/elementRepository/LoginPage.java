package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id="Email")
	private WebElement emailTextField;
	
	
	@FindBy(id ="Password")
	private WebElement passwordTextField;
	
	@FindBy(id="RememberMe")
	private WebElement rememberMeCheckBox;
	
	
	@FindBy(xpath="//a[text()='Forgot password?']")
	private WebElement ForgotPassword;
	
	
	@FindBy(xpath="//input[@class='button-1 login-button']")
	private WebElement LoginButton;
	
	@FindBy(xpath="//a[text()='Log out']")
	private WebElement LogoutButton;
	
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}


	public WebElement getEmailTextField() {
		return emailTextField;
	}


	public WebElement getPasswordTextField() {
		return passwordTextField;
	}


	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}


	public WebElement getForgotPassword() {
		return ForgotPassword;
	}


	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	public WebElement getLogoutButton() {
		return LogoutButton;
		
	}
	
	
	
}


