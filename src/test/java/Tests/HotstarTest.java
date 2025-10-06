package Tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static util.AdbCommandsClass.*;

import java.time.Duration;

public class HotstarTest extends BaseClass {
	
	
	@Test(description="Hotstar in app testing")
	public void test01() throws InterruptedException {
		launchApp("in.startv.hotstar/com.hotstar.MainActivity");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement search=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc='Search']")));
		search.click();
		
		WebElement searchField=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text,\"Search for \")]")));
		searchField.click();
	
		Thread.sleep(2000);
		WebElement searchF = wait.until(ExpectedConditions
		        .visibilityOfElementLocated(AppiumBy.className("android.widget.EditText")));
		searchF.sendKeys("Su from so");
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.className("android.widget.Button"))).click();

		//driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='tag_search_bar']/android.view.View")).sendKeys("Su From So");
		//driver.pressKey(new KeyEvent(AndroidKey.A));
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.terminateApp("in.startv.hotstar");
	}
	

}
