public class BasicTestSetup {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        /* These are the capabilities we must provide to run our test on TestObject */
        capabilities.setCapability("testobject_api_key", "YOUR_API_KEY");
        capabilities.setCapability("testobject_device", "Motorola_Moto_G_2nd_gen_real");

        /* The driver will take care of establishing the connection, so we must provide
        * it with the correct endpoint and the requested capabilities. */
        driver = new AndroidDriver(new URL("http://appium.testobject.com/wd/hub"), capabilities);

    }

    /* We disable the driver after EACH test has been executed. */
    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testMethod() {
        /* Your test. */
    }

}
