package Tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

import static util.AdbCommandsClass.*;

import java.time.Duration;
import java.util.List;

public class JioSaavnTest extends BaseClass{
	
	@Test
	public void test() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		String songName="rebel song";
		
		launchApp("com.jio.media.jiobeats/com.jio.media.mobile.apps.jiobeats.splash.SplashScreen");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Search']"))).click();
		
		WebElement searchField=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.AutoCompleteTextView")));
		
		searchField.click();
		
		searchField.sendKeys(songName);
		
		List<WebElement> songs=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.className("android.widget.TextView")));
		
		for(WebElement song:songs) {
			if(song.getText().equalsIgnoreCase(songName)) {
				song.click();
				break;
			}
		}
		
		List<WebElement> searchedSongs=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//o.getMandatorySystemGestureInsets[contains(@resource-id,'com.jio.media.jiobeats:id')]/android.view.View/android.view.View")));
		
		searchedSongs.get(0).click();
		
		
		
		
	}

}
