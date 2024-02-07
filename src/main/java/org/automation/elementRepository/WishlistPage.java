package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishlistPage {

	@FindBy(xpath = "//input[@name='removefromcart']")
	private WebElement removeCheckBox;
	
	@FindBy(xpath = "//input[@name='updatecart']")
	private WebElement updateCart;
	
	@FindBy(xpath = "//div[contains(text(),'The wishlist is empty!')]")
	private WebElement wishlistText;

	public WebElement getWishlistText() {
		return wishlistText;
	}

	public WebElement getRemoveCheckBox() {
		return removeCheckBox;
	}

	public WebElement getUpdateCart() {
		return updateCart;
	}
	
	
	
	public WishlistPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
