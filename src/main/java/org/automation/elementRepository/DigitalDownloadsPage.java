package org.automation.elementRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DigitalDownloadsPage {

	@FindBy(xpath = "//h1[text()='Digital downloads']")
	private WebElement DigitalDownloadsText;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement AddToCartButton;
	
	public WebElement getDigitalDownloadsText() {
		return DigitalDownloadsText;
	}

	public WebElement getAddToCartButton() {
		return AddToCartButton;
	}
	
	
	
}
