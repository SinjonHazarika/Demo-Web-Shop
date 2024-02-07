package org.automation.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FictionEXPage {

	@FindBy(xpath="//input[@value='Add to wishlist']")
	private WebElement AddToWishList;

	public WebElement getAddToWishList() {
		return AddToWishList;
	}
	
	public FictionEXPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
