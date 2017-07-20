require 'appium_lib'
require 'test/unit'
require 'test_object_test_result_watcher'

class BasicTestSetup < Test::Unit::TestCase
  API_KEY = 'YOUR_API_KEY'

  def api_key
    if API_KEY == 'YOUR_API_KEY'
      raise "Please set your API key to run this example (see https://github.com/testobject-sample-scripts/setups/tree/master/ruby/test_unit/watcher)"
      exit 1
    else
      return API_KEY
    end
  end

  def setup
    desired_capabilities = {
        caps:       {
            testobject_api_key: api_key,
            platformName: "Android",
            # supply `platformVersion` without `deviceName` to get any available device with that version dynamically
            platformVersion: '7', # Optional
            deviceName: 'Samsung Galaxy S8', # Optional
            testobject_report_results: true
        },
        appium_lib: {
            server_url: 'https://eu1.appium.testobject.com/wd/hub',
            #server_url: 'https://us1.appium.testobject.com/wd/hub',  # your device is located in the US ? , then uncomment this line and remove the previous one.
            wait: 10
        }
    }

    # Start the driver
    @driver = Appium::Driver.new(desired_capabilities).start_driver
    @testwatcher = TestObjectTestResultWatcher.new(desired_capabilities, @driver)
  end

  # test method names must start with "test_"
  # to be recognized by the test-unit framework
  def test_login
    # Your test
  end

  def teardown
    @testwatcher.report_results_and_cleanup(passed?) if @testwatcher
  rescue Selenium::WebDriver::Error::UnknownError => e
    raise e unless e.message.match /Unable to find session with requested ID/
  end
end
