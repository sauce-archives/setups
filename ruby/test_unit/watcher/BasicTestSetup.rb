require 'appium_lib'
require 'test/unit'
require 'test_object_test_result_watcher'

class BasicTestSetup < Test::Unit::TestCase
  def setup
    desired_capabilities = {
        caps:       {
            testobject_api_key: 'YOUR_API_KEY',
            testobject_device: 'Motorola_Moto_G_2nd_gen_real',
            testobject_report_results: true
        },
        appium_lib: {
            server_url: 'http://appium.testobject.com/wd/hub',
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
