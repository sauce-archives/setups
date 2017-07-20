
public class BasicTestSetup {

	private AppiumDriver driver;

	@Before
	public void setUp() throws Exception {

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

		/*  The driver will take care of establishing the connection, so we must provide
		*  it with the correct endpoint and the requested capabilities. */
		driver = new AndroidDriver(EU_endpoint, capabilities);

	}

	/* We disable the driver after EACH test has been executed. */
	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void testMethod() {
		/* Your test. */
	}

}
