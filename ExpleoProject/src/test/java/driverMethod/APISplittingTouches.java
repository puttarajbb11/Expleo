package driverMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class APISplittingTouches 
{
	@Test 

	public void ApiDemo() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto g60");
		dc.setCapability(MobileCapabilityType.UDID, "ZD2222J522");
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", ".ApiDemos");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);

		URL url=new URL("http://localhost:4723/wd/hub");
		AndroidDriver driver=new AndroidDriver(url,dc);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

		MobileElement views=(MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		driver.tap(1, views, 500);
		scrollToElement(driver, "text", "Splitting Touches across Views");
		Thread.sleep(3000);
		scrollToElement(driver, "text", "Autun");
		String Tosat = driver.findElementByXPath("//android.widget.Toast[1]").getAttribute("name");
		System.out.println(Tosat);
		//		Assert.assertEquals(Tosat,);
		//		Thread.sleep(3000);

	}
	public void scrollToElement(AndroidDriver driver, String an, String av)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+an+"(\""+av+"\"))").click();
	}

}
