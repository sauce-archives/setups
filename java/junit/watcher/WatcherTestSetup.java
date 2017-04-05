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

        capabilities.setCapability("testobject_api_key", "YOUR_API_KEY");
        capabilities.setCapability("testobject_device", "TESTOBJECT_DEVICE_NAME");

        driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);

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

