var assert = require('assert');

describe('TestObject website', function() {
    before(function() {
        browser.timeouts('implicit', 10000);
        browser.url('https://testobject.com');
    });

    it('Opens features page', function() {
        var learnMore = "//a[contains(text(), 'Learn More')]";
        browser.scroll(learnMore);
        browser.element(learnMore).click();
        var pageUrl = browser.getUrl();
        assert.equal(pageUrl, "https://testobject.com/features")
    });
});
