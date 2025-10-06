package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import static util.AppiumUtils.*;

public class CartPage {
	
	public AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPriceList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalPriceText;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement termsAndConditionsButton;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement closeButton;
	
	@AndroidFindBy(id="android:id/message")
	private WebElement messageText;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement proceedButton;

	public boolean vlaidateCartPage() {
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			flag=wait.until(ExpectedConditions.textToBe(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"), "Cart"));
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred while validating the cart pahe");
		}
		return flag;
	}
	
	public boolean priceCheck() {
		boolean flag=false;
		double sum=0;
		try {
			for(WebElement eachPrice:productPriceList) {
				double price=typeConvert(eachPrice.getText());
				sum+=price;
			}
			double totalSum =typeConvert(totalPriceText.getText());
			System.out.println("Sum : " +sum);
			System.out.println("Total sum is  : "+totalSum);
			Assert.assertEquals(sum, totalSum,"Sum and total sum is not matching");
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred, on checking the price");
		}
		return flag;
	}
	
	public boolean pressTermsAndContitions() {
		boolean flag=false;
		try {
			longPress(driver,termsAndConditionsButton);
			System.out.println(messageText.getText());
			closeButton.click();
			
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during clicking on terms and conditions button");
		}
		return flag;
	}
	public boolean clickVisitToBrowserButton() {
		boolean flag=true;
		try {
		//	Thread.sleep(3000);
			checkBox.click();
			proceedButton.click();
			flag=true;
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during clicking the visit browser button");
		}
		return flag;
	}
	
	
	
	

}
