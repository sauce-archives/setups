@Listeners({ TestObjectTestNGTestResultWatcher.class })
public class AppiumDriverCalculatorWatcherTestTestNG implements TestObjectWatcherProvider {

    private TestObjectListenerProvider provider = TestObjectListenerProvider.newInstance();

    @BeforeMethod
    public void beforeTest() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(TestObjectCapabilities.TESTOBJECT_API_KEY, "YOUR_API_KEY");
        capabilities.setCapability(TestObjectCapabilities.TESTOBJECT_DEVICE, "TESTOBJECT_DEVICE_NAME");

        AppiumDriver appiumDriver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);
        provider.setDriver(appiumDriver);
        provider.setLocalTest(false);
    }

    @Test
    public void testMethod() {
        /* Your test. */
    }

    @AfterMethod
    public void tearDown() {
        provider.getAppiumDriver().quit();
    }

    @Override
    public TestObjectListenerProvider getProvider() {
        return provider;
    }
}
