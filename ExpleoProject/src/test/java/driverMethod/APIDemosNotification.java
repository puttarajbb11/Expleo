package driverMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class APIDemosNotification
{
	AndroidDriver driver;
	@Test
	
	public void APIDemos() throws MalformedURLException, InterruptedException
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

		MobileElement views=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='App']");
		driver.tap(1, views, 500);
		driver.findElementByAccessibilityId("Notification").click();
		driver.findElementByAccessibilityId("IncomingMessage").click();
		driver.findElementByAccessibilityId("Show App Notification").click();
		driver.swipe(500, 26, 500, 1200, 500);
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.LinearLayout[@index='2']").click();
		MobileElement 	jeo=(MobileElement) driver.findElementById("io.appium.android.apis:id/from");
		Assert.assertEquals(jeo.getText(),"Joe");
		
		Thread.sleep(5000);
		driver.quit();

	}

}
