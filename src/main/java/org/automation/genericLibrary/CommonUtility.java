package org.automation.genericLibrary;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {

	Select s;
	
	public int getRandomNumber() {
		Random r = new Random();
		return r.nextInt(2000);	
	}
	
	public void toTakesScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(FrameWorkConstants.screenShot_Path);
		FileHandler.copy(src,trg);
	}
	
	public void selectDropDownByIndex(WebElement dropDown, int indexNum) {
		s = new Select(dropDown);
		s.selectByIndex(indexNum);
	}
	
	public void selectDropDownByValue(WebElement dropDown, String value) {
		s = new Select(dropDown);
		s.selectByValue(value);		
	}
	
	public void selectDropDownByVisibleText(WebElement dropDown, String visibleText) {
		s = new Select(dropDown);
		s.selectByVisibleText(visibleText);
	}
	
	
	public void javaScriptExecutor(WebElement driver, WebElement target ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",target);
	}
	
	public void scrollActionsClass(WebDriver driver, WebElement target) {
		Actions act = new Actions(driver);
		act.scrollToElement(target);
	}

	
	
}
