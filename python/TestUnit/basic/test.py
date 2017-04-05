import unittest
from appium import webdriver

class TestClass(unittest.TestCase):

    def setUp(self):
        desired_capabilities = {}
        desired_capabilities['testobject_api_key'] = 'your TestObject API key here'
        desired_capabilities['testobject_device'] = 'LG_Nexus_4_E960_real'
        desired_capabilities['testobject_appium_version'] = '1.5.2-patched-chromedriver'
        testobject_endpoint = 'http://appium.testobject.com:80/api/appium/wd/hub'
        self.driver = webdriver.Remote(testobject_endpoint, desired_capabilities)

    # All test methods starts with the word "test_"
    def test_open_testobject_website(self):
        self.driver.get("https://testobject.com/")
        if not "TestObject" in self.driver.title:
            raise Exception("Unable to load TestObject")

    def tearDown(self):
        self.driver.quit()

# This will trigger the test
if __name__ == '__main__':
    unittest.main()
