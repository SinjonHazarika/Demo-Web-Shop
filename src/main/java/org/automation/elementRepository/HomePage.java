package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	
	@FindBy(xpath="//a[text()='Log in']")
	private WebElement Login;
	
	@FindBy(xpath="//a[text()='Register']")
	private WebElement Register;
	
	@FindBy(xpath = "//ul[1]//a[contains(text(),'Digital downloads')]")
	private WebElement DigitalDownloads;

	@FindBy(linkText = "Shopping cart")
	private WebElement ShoppingCartButton;
	
	@FindBy(xpath="//ul[@class='top-menu']//a[contains(text(),'Books')]")
	private WebElement BooksLink;
	
	
	@FindBy(xpath="//li[4]//a[@class='ico-wishlist']")
	private WebElement WishlistLink;

	public WebElement getWishlistLink() {
		return WishlistLink;
	}	
	
	
	public WebElement getBooksLink() {
		return BooksLink;
	}

	public WebElement getShoppingCartButton() {
		return ShoppingCartButton;
	}
	
	public WebElement getDigitalDownloads() {
		return DigitalDownloads;
	}

	public WebElement getLogin() {
		return Login;
	}

	public WebElement getRegister() {
		return Register;
	}
	
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

		
}
