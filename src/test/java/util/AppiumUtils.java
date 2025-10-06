package util;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppiumUtils {
	
	public static void elementClick(AndroidDriver driver,WebElement element ) {
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(element)).click();
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured during the clicking the element");
		}
	}
	
	public static void scrollToElement(String value, AndroidDriver driver) {
		try {
			driver.findElement(AppiumBy.androidUIAutomator(
				    "new UiScrollable(new UiSelector()).scrollIntoView(text(\""+value+"\"));"
					));
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during the scrolling ");
		}
	}
	public static String initValue(String value) {
		value=value.toLowerCase();
		StringBuilder sb=new StringBuilder();
		char[] ch=value.toCharArray();
		sb.append((char)(ch[0]-32));
		for(int i=1;i<ch.length;i++) {
			sb.append(ch[i]);
		}
		return sb.toString();
	}
	
	public static Double typeConvert(String s) {
		return Double.parseDouble(s.replace("$", ""));
	}
	public static void  longPress(WebDriver driver, WebElement element) {
		((JavascriptExecutor)driver).executeScript(
				"mobile: longClickGesture", ImmutableMap.of(
						"elementId",((RemoteWebElement)(element)).getId(),
						"duration",2000
						));
	}

}
