package Tests;

import java.io.File;
import java.net.URI;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {
	
	public AndroidDriver driver;
	
	public AppiumDriverLocalService service;
	
	
	@BeforeSuite(alwaysRun=true)
	public void config() {
		try {
		//server
		String appiumHomePath = System.getenv("APPIUM_HOME");
		System.out.println(appiumHomePath);
		File file = new File(
				appiumHomePath + File.separator + "build" + File.separator + "lib" + File.separator + "main.js");
		service=new AppiumServiceBuilder().withAppiumJS(file).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		//UiAutomator2Options
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		options.setUdid("emulator-5554");
		options.setDeviceName("Shetty");
	//	options.setUdid("ea1ae449");
		options.setNoReset(true);
		options.setChromedriverExecutable("C:\\Users\\User\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		options.setCapability("appium:ignoreHiddenApiPolicyError", true);//for physical devices
		
		//AndroidDriver
		
		driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@AfterSuite(alwaysRun=true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.terminateApp("com.androidsample.generalstore");//pass the app package name
	}

}
