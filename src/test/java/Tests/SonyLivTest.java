package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

import static  util.AdbCommandsClass.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SonyLivTest extends BaseClass {
	
	@Test(description="SonyLive test")
	public void test() throws InterruptedException {
		//launchApp("com.sonyliv/com.sonyliv.splash.SplashActivity");//physical device
		launchApp("com.jiotv.sonyliv/com.sonyliv.ui.splash.SplashActivity");//emulator
		System.out.println("App launched successfully");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement profileButton=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc='Profile']")));
		profileButton.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.sonyliv:id/more_menu_title' and @text='Help Center']"))).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@resource-id='com.sonyliv:id/more_menu_title' and @text='Terms of Use']"))).click();
		
		String s=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.sonyliv:id/webView"))).getText();
		System.out.println("String value is :"+s);
		Thread.sleep(5000);
		Set<String> set=driver.getContextHandles();
		List<String> list=new ArrayList<>(set);
		System.out.println(list.get(1));
		
		driver.context(list.get(1));
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		for(WebElement link:links) {
			System.out.println(link.getText());
		}
		
	}
	
	
	@AfterClass(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(8000);
		driver.terminateApp("com.sonyliv");
	}

}
