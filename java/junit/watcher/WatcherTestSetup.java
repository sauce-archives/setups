
public class WatcherTestSetup {

    /* This is the key piece of our test, since it allows us to
   * connect to the device we will be running the app onto.*/
    private AppiumDriver driver;

    /* Sets the test name to the name of the test method. */
    @Rule
    public TestName testName = new TestName();

    /* Takes care of sending the result of the tests over to TestObject. */
    @Rule
    public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();

    /* This is the setup that will be run before the test. */
    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        /*  1. Choose your project */
        capabilities.setCapability("testobject_api_key", "YOUR_API_KEY");

        /*  2. Select your device:
		*   Specify a `platformVersion` without `deviceName` to get any available device with that platform version.
		*   Not selecting a device at all is also a valid choice, we will select it carefully for you */
        capabilities.setCapability("platformVersion", "7"); // Optional
        capabilities.setCapability("deviceName", "Samsung Galaxy S8"); // Optional

		/*  3. Where is your device located? */
        URL EU_endpoint = new URL("https://eu1.appium.testobject.com/wd/hub");
        URL US_endpoint = new URL("https://us1.appium.testobject.com/wd/hub");

        /*  The driver will take care of establishing the connection, so we must provide
		*   it with the correct endpoint and the requested capabilities. */
        driver = new AndroidDriver(EU_endpoint, capabilities);

        /* IMPORTANT! We need to provide the Watcher with our initialized AppiumDriver */
        resultWatcher.setRemoteWebDriver(driver);

    }

    /* IMPORTANT! driver.quit() is not called anymore, as the Watcher is now
       taking care of this. You can get rid of the tearDown method. */

    @Test
    public void testMethod() {
        /* Your test. */
    }

}

