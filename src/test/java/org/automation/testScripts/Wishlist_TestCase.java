package org.automation.testScripts;

import org.automation.elementRepository.BooksPage;
import org.automation.elementRepository.FictionEXPage;
import org.automation.elementRepository.HomePage;
import org.automation.elementRepository.WishlistPage;
import org.automation.genericLibrary.BaseTest;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Wishlist_TestCase extends BaseTest {
	
	@Test
	public void wishListTestCase() 
	{
		
		//Step 1 : Click on Books link
		HomePage home_Page = new HomePage(driver);
		home_Page.getBooksLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/books", "Books page not displayed");
		Reporter.log("Books page is displayed",true);
		
		//Step 2 : Click on Fiction EX
		BooksPage books_Page = new BooksPage(driver);
		books_Page.getFictionEXLink().click();
		
		Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/fiction-ex", "FictionEX page not displayed");
		Reporter.log("FictionEX page is displayed",true);
		
		//Step 3 : Click on Add to wish list
		FictionEXPage fictionEX_Page = new FictionEXPage(driver);
		fictionEX_Page.getAddToWishList().click();
		
		//Step 4 : Click on wish list link
		home_Page.getWishlistLink().click();
		Assert.assertEquals(driver.getCurrentUrl(),"https://demowebshop.tricentis.com/wishlist", "Wish list page not displayed");
		Reporter.log("Wish list page is displayed",true);
		
		//Step 5 : Click on Remove Check box
		WishlistPage wishlist_Page = new WishlistPage(driver);
		wishlist_Page.getRemoveCheckBox().click();
		
		//Step 6 : Click on Update Wish list
		wishlist_Page.getUpdateCart().click();
		Assert.assertEquals(wishlist_Page.getWishlistText().getText(),"The wishlist is empty!","Error");
		Reporter.log("TestCase Passed",true);
		
		
	}

}
