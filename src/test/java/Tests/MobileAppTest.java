package Tests;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.GeneralStorePage;
import Pages.ProductPage;

import static util.AdbCommandsClass.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MobileAppTest extends BaseClass{
	
	GeneralStorePage gp;
	ProductPage pp;
	CartPage cp;
	
	
	@BeforeClass(alwaysRun=true)
	public void setUp() {
		gp=new GeneralStorePage(driver);
		pp= new ProductPage(driver);
		cp=new CartPage(driver);
	}
	
	@Test
	public void test01() throws InterruptedException {
		boolean status=false;
		launchApp("com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity");
		status=gp.verifyGeneralStroePage();
		Assert.assertTrue(status, "Navigation is falied");
		status=gp.selectCountry("Austria");
		Assert.assertTrue(status,"Failed to select country");
		gp.setName("Mohini");
		status=gp.setGender("female");
		Assert.assertTrue(status,"Unable to select gender");
		status=gp.clickOnLetsPlayButton();
		Assert.assertTrue(status,"Unable to click on lets shop button");
		status=pp.validateProductPageNavigation();
		Assert.assertTrue(status,"Product page navigation is failed");
		pp.addProductTocart("Air Jordan 1 Mid SE");
		status=pp.addProductTocart("PG 3");
		Assert.assertTrue(status,"Unagle to select the product");
		status=pp.clickCartButton();
		Assert.assertTrue(status,"Unable to click on cart button");
		status=cp.vlaidateCartPage();
		Assert.assertTrue(status,"cartpage navigation is failed");
		status=cp.priceCheck();
		Assert.assertTrue(status,"price is not matched");
		cp.pressTermsAndContitions();
		status=cp.clickVisitToBrowserButton();
		Assert.assertTrue(status,"Browser navigation is failed");
		
		Thread.sleep(5000);
		
		Set<String> set=driver.getContextHandles();
		List<String> list=new ArrayList<>(set);
		driver.context(list.get(1));
		
		driver.findElement(By.name("q")).sendKeys("Abishek", Keys.ENTER);
	}

}
