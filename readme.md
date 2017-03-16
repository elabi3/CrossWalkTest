# CrossWalkTest

Goals:

  - Learn how to use an Android system webview
  - Learn how to use a third party webview (Crosswalk)
  - Performance test with both webviews

# Test

To test the performance of these webviews i use:

  - https://chromium.github.io/octane/
  - http://www.wirple.com/bmark/

Device: Nexus 4 (mako) - Android 5.1.1 (api 22)

| WebView - v39 | Crosswalk - 23.53.589.4 |
| ------ | ------ |
| Octane: 2721 | Octane: 2690  |
| Wirple: 74 <img src="https://github.com/elabi3/CrossWalkTest/blob/master/Wirple%20-%20Webview.png">| Wirple: 96 <img src="https://github.com/elabi3/CrossWalkTest/blob/master/Wirple%20-%20Crosswalk.png">|


# Crosswalk Installation

Add this line to your gradle file:

```
    compile 'org.xwalk:xwalk_core_library:23.53.589.4'
```

Check latest version from this website:

* [Download](https://download.01.org/crosswalk/releases/crosswalk/android/maven2/org/xwalk/xwalk_core_library/) 


# References

To develop this example app i read multiple articles that inspire to me:

* [Crosswalk Project](https://crosswalk-project.org/) 

* [Shared Mode vs. Embedded Mode](https://crosswalk-project.org/documentation/shared_mode.html) 


# Author

Abimael Barea [@elabi3](https://github.com/elabi3)

