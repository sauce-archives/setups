using NUnit.Framework;
using System;
using OpenQA.Selenium.Appium.Android;
using OpenQA.Selenium.Remote;
using OpenQA.Selenium.Appium;
using System.Net;

namespace AppiumBasicSetup
{
	[TestFixture()]
	public class BasicTest
	{
		AndroidDriver<AppiumWebElement> driver;
	
		[SetUp()]
		public void SetUp()
		{
			ServicePointManager.SecurityProtocol = SecurityProtocolType.Ssl3 | SecurityProtocolType.Tls12 | SecurityProtocolType.Tls11 | SecurityProtocolType.Tls;
			DesiredCapabilities capabilities = new DesiredCapabilities();

			/*  1. Choose your project */
			capabilities.setCapability("testobject_api_key", "YOUR_API_KEY");

			/*  2. Select your testing device:
			*   Specify a `platformVersion` without `deviceName` to get any available device with that platform version.
			*   Not selecting a device at all is also a valid choice, we will select it carefully for you */
			capabilities.SetCapability("platformVersion", "7"); // Optional
			capabilities.SetCapability("deviceName", "Samsung Galaxy S8"); // Optional
			
			/*  3. Where is your device located? */
			Uri EU_endpoint = new Uri("https://eu1.appium.testobject.com/wd/hub");
			Uri US_endpoint = new Uri("https://us1.appium.testobject.com/wd/hub");

			/*  The driver will take care of establishing the connection, so we must provide
			*  it with the correct endpoint and the requested capabilities. */
			driver = new AndroidDriver<AppiumWebElement>(EU_endpoint, capabilities);

		}
		
		[Test()]
		public void FirstTest()
		{
			driver.GetScreenshot();
		}
		
		[TearDown()]
		public void TearDown()
		{
			driver.Quit();
		}
	}
}
