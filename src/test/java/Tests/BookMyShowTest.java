package Tests;

import org.testng.annotations.Test;

import static util.AdbCommandsClass.*;

public class BookMyShowTest extends BaseClass{
	
	@Test
	public void test() {
		launchApp("com.bt.bms/com.movie.bms.splashscreen.SplashScreenActivity");
	}

}
