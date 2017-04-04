var config = {
    protocol: 'https',
    host: 'app.testobject.com',
    port: '443',
    path: '/api/appium/wd/hub',
    capabilities: [{
        testobject_api_key: 'YOUR API KEY',
        testobject_device: 'Motorola_Moto_G_2nd_gen_real',
        browserName: 'Chrome'
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
        ui: 'bdd',
        enableTimeouts: false
    }
}

exports.config = config
