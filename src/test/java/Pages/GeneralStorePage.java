package Pages;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static util.AppiumUtils.*;

public class GeneralStorePage {
	public AndroidDriver driver;
	
	public GeneralStorePage(AndroidDriver driver) {
		this.driver=driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
//	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
//	private WebElement generalStoreText;
	
	@AndroidFindBy(className="android.widget.Spinner")
	private WebElement countryDropDown;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(className="android.widget.RadioButton")
	private List<WebElement> genderRadioButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letsShopButton;
	
	public boolean verifyGeneralStroePage() {
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			
			flag=wait.until(ExpectedConditions.textToBe(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"),"General Store"));
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during the navigating to general store page");
		}
		return flag;
	}
	public boolean setGender(String name) {
		boolean flag=false;
		try {
			name=initValue(name);
			for(WebElement gender:genderRadioButton) {
				if(gender.getText().equalsIgnoreCase(name)) {
					System.out.println(gender.getText());
					gender.click();
					flag=true;
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean selectCountry(String countryName) {
		boolean flag=false;
		try {
			elementClick(driver,countryDropDown);
			scrollToElement(countryName, driver);
			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='"+countryName+"']")).click();
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during selecting the country from dropdown");
		}
		return flag;
	}
	
	public void setName(String name) {
		try {
			nameField.sendKeys(name);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurred during entering the name");
		}
	}
	
	public boolean clickOnLetsPlayButton() {
		boolean flag=false;
		try {
			letsShopButton.click();
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occured during selecting the lets play button");
		}
		return flag;
	}

}
