var config = {
    protocol: 'https',
    host: 'eu1.appium.testobject.com',
    //host: 'us1.appium.testobject.com', // your device is located in the US ? , then uncomment this line and remove the previous one.
    port: '443',
    path: '/wd/hub',
    capabilities: [{
        testobject_api_key: 'YOUR_API_KEY',
        platformName: 'Android',
        /* supply `platformVersion` without `deviceName` to get any available device with that version dynamically */
        platformVersion: '7', // Optional
        deviceName: 'Samsung Galaxy S8' // Optional
    }],

    specs: [
        './specs/**/*.js'
    ],

    sync: true,
    logLevel: 'verbose',
    coloredLogs: true,
    screenshotPath: './errorShots/',
    waitforTimeout: 10000,
    connectionRetryTimeout: 10 * 60000,
    connectionRetryCount: 3,
    framework: 'mocha',
    mochaOpts: {
        ui: 'bdd'
    }
}

exports.config = config
