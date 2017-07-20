import unittest
from appium import webdriver


class TestClass(unittest.TestCase):

	def setUp(self):
		desired_capabilities = {}

		# 1. Choose your project
		desired_capabilities['testobject_api_key'] = 'YOUR_API_KEY'
		desired_capabilities['platformName'] = 'Android'

		# 2. Select your device:
		#   Specify a `platformVersion` without `deviceName` to get any available device with that platform version.
		#   Not selecting a device at all is also a valid choice, we will select it carefully for you
		desired_capabilities['platformVersion'] = '7'  # Optional
		desired_capabilities['deviceName'] = 'Samsung Galaxy S8'  # Optional
		
		# The driver will take care of establishing the connection, so we must provide
		# it with the correct endpoint and the requested capabilities.
		endpoint = 'http://appium.testobject.com:80/api/appium/wd/hub'
		self.driver = webdriver.Remote(endpoint, desired_capabilities)


	# All test methods starts with the word "test_"
	def test_open_testobject_website(self):
		self.driver.get("https://testobject.com")
		if not "TestObject" in self.driver.title:
			raise Exception("Unable to load TestObject")


	def tearDown(self):
		self.driver.quit()


# This will trigger the test
if __name__ == '__main__':
	unittest.main()

