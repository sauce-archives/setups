var assert = require('assert')

describe('TestObject website', function() {
    before(function() {
        browser.timeouts('implicit', 10000)
    })

    it('Opens TestObject', function() {
        browser.url('https://testobject.com')
        var pageUrl = browser.getUrl()
    })
})
