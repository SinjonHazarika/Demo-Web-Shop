package org.automation.testScripts;

import java.util.List;

import org.automation.elementRepository.CartPage;
import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.LoginPage;
import org.automation.elementRepository.RegisterPage;
import org.automation.genericLibrary.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(org.automation.genericLibrary.ListnersImplementation.class)
public class AddToCart_TestCase extends BaseTest {

	
	LoginPage login_Page = new LoginPage(driver);
	RegisterPage register_Page = new RegisterPage(driver);
	
	
	@Test
	public void AddToCart() throws InterruptedException {
		
		
		//Step 1 : Click on Digital Downloads
		HomePage home_Page = new HomePage(driver);
		home_Page.getDigitalDownloads().click();
		
		//Step 2 : Validating
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/digital-downloads","Digital Download Page not Displayed");
		Reporter.log("Digital Download Page Displayed", true);
		//
		//
		//
		

		//Step 3 : Adding Products to cart
		//DigitalDownloadsPage digital_Downloads_Page = new DigitalDownloadsPage();
		List<WebElement> addToCart = driver.findElements(By.xpath("//input[@value='Add to cart']"));
		for(WebElement addToCarts : addToCart) {
			addToCarts.click();
			Thread.sleep(3000);
		}
		
		//Step 4 : Click on cart
		home_Page.getShoppingCartButton().click();
		
		//Step 5 : Validating if Shopping Cart page displayed
		Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/cart","Shopping cart page displayed");
		Reporter.log("Shopping cart page displayed", true);
		
		//Step 6 : Validate products added to cart
		List<WebElement> products = driver.findElements(By.xpath("//a[@class='product-name']"));
		if(addToCart.size()==products.size()) {
			Reporter.log("All products added to cart", true);
		}
		else
			Reporter.log("Products not added to cart", true);
		
		//Step 7 : Click on CheckBox
		List<WebElement>checkbox = driver.findElements(By.xpath("//input[@name='removefromcart']"));
		for(WebElement checkboxs : checkbox) {
			checkboxs.click();
		}
		
		//Step 8 : Click on update cart
		CartPage cart_Page = new CartPage(driver);
		cart_Page.getUpdateCart().click();
		
		//Step 9 : Verify  products are removed
		Assert.assertEquals(cart_Page.getMessage().getText(), "Your Shopping Cart is empty!", "products not removed");
		Reporter.log("Products are removed", true);
	}
}
