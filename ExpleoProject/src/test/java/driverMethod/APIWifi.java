package driverMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIWifi 
{
	AndroidDriver driver;
	@Test

	public void APIDemosSplitting() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto");
		dc.setCapability(MobileCapabilityType.UDID, "ZD2222J522");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		dc.setCapability(MobileCapabilityType.NO_RESET, "true");

		URL url=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		MobileElement views=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Preference']");
		driver.tap(1, views, 500);
		driver.findElementByAccessibilityId("3. Preference dependencies").click();
		driver.findElementById("android:id/checkbox").click();
		Thread.sleep(2000);
		ScreenOrientation src = driver.getOrientation();
		driver.rotate(src.LANDSCAPE);
		driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
		driver.findElementById("android:id/edit").sendKeys("Puttaraja");
		driver.hideKeyboard();
		driver.findElementById("android:id/button1").click();
		
		Thread.sleep(5000);
		driver.quit();


	}

}
