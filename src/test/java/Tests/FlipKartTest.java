package Tests;

import org.testng.annotations.Test;

import static util.AdbCommandsClass.*;

public class FlipKartTest extends BaseClass {
	@Test
	public void test() {
		launchApp("com.flipkart.android/.SplashActivity");
	}

}
