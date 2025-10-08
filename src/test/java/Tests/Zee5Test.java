package Tests;
import static util.AdbCommandsClass.*;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Zee5Test extends BaseClass {
	
	@Test
	public void test() throws InterruptedException {
		
		String contentName="rrr";
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		launchApp("com.graymatrix.did/com.zee5.splash.SplashActivity");
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("com.graymatrix.did:id/home_toolbar_brand_logo")));
		
		driver.findElement(AppiumBy.id("com.graymatrix.did:id/home_toolbar_search_icon")).click();
		
		//Clicking on search field, 
		
		WebElement searchField=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text,'Search')]")));
		
		searchField.click();
		
		//Now focus is on search field, android.widget.EditText is common for android search field
		
		WebElement search=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));
		
		search.sendKeys(contentName);
		Thread.sleep(3000);
		
		List<WebElement> suggestionContents=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@resource-id='Search_ItemSearchSuggestionsText']")));
		//driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		
		for(WebElement content:suggestionContents) {
			if(content.getText().equalsIgnoreCase(contentName)) {
				content.click();
				break;
			}
		}
		
		List<WebElement> allContents=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(AppiumBy.className("android.widget.ImageView")));
		allContents.get(0).click();
		
		
	}
	
	
	
	//@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.terminateApp("com.graymatrix.did");
	}

}
