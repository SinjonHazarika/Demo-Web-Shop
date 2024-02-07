package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartPage {

	@FindBy(name  ="updatecart")
	private WebElement updateCart;
	
	public WebElement getUpdateCart() {
		return updateCart;
	}


	@FindBy(xpath ="//div[contains(text(), 'Your Shopping Cart is empty!']")
	private WebElement message;
	
	public WebElement getMessage() {
		return message;
	}
	
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
