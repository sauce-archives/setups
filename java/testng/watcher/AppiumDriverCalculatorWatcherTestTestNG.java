@Listeners({ TestObjectTestNGTestResultWatcher.class })
public class AppiumDriverCalculatorWatcherTestTestNG implements TestObjectWatcherProvider {

	private TestObjectListenerProvider provider = TestObjectListenerProvider.newInstance();

	@BeforeMethod
	public void beforeTest() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

        /*  1. Choose your project */
		capabilities.setCapability("testobject_api_key", "YOUR_API_KEY");

        /*  2. Select your testing device:
		*   Specify a `platformVersion` without `deviceName` to get any available device with that platform version.
		*   Not selecting a device at all is also a valid choice, we will select it carefully for you */
		capabilities.setCapability("platformVersion", "7"); // Optional
		capabilities.setCapability("deviceName", "Samsung Galaxy S8"); // Optional

		/*  3. Where is your device located? */
		URL EU_endpoint = new URL("https://eu1.appium.testobject.com/wd/hub");
		URL US_endpoint = new URL("https://us1.appium.testobject.com/wd/hub");

        /*  4. The driver will take care of establishing the connection, so we must provide
		*  	  it with the correct endpoint and the requested capabilities. */
		AppiumDriver driver = new AndroidDriver(EU_endpoint, capabilities);

		/* IMPORTANT! We need to provide the Watcher with our initialized AppiumDriver */
		provider.setDriver(driver);

	}

	@Test
	public void testMethod() {
		/* Your test. */
	}

	@AfterMethod
	public void tearDown() {
		provider.getAppiumDriver().quit();
	}

	public TestObjectListenerProvider getProvider() {
		return provider;
	}
}
