/* You must add these two annotations on top of your test class. */
@TestObject(testLocally = false, testObjectApiKey = "YOUR_API_KEY", testObjectSuiteId = YOUR_SUITE_NUMBER)
@RunWith(TestObjectAppiumSuite.class)
public class CompleteTestSetup {

    private AppiumDriver driver;

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestObjectTestResultWatcher resultWatcher = new TestObjectTestResultWatcher();

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("testobject_api_key", resultWatcher.getApiKey());
        capabilities.setCapability("testobject_test_report_id", resultWatcher.getTestReportId());

        driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);

        resultWatcher.setAppiumDriver(driver);

    }

    @Test
    public void testMethod() {
        /* Your test. */
    }

}
