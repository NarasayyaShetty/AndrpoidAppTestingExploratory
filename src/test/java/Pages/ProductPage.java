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
public class ProductPage {
	public AndroidDriver driver;
	
	public ProductPage(AndroidDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cartButton;
	
	public boolean validateProductPageNavigation() {
		boolean flag=false;
		try {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.textToBe(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"), "Products"));
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during navigation on productPage");
		}
		return flag;
	}
	
	public boolean addProductTocart(String productName) {
		boolean flag=false;
		try {
			scrollToElement(productName, driver);
			List<WebElement> products=driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
			for(int i=0;i<products.size();i++) {
				String text= products.get(i).getText();
				if(text.equalsIgnoreCase(productName)) {
					System.out.println(text);
					driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
					flag=true;
					break;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during selecting the product to cart");
		}
		return flag;
	}
	
	public boolean clickCartButton() {
		boolean flag=false;
		try {
			cartButton.click();
			flag=true;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception is occurred during clicking the cart button");
		}
		return flag;
	}

}
