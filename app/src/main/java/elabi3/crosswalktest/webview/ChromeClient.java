package elabi3.crosswalktest.webview;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;

/**
 * Created by elabi3 on 1/5/16.
 **/
public class ChromeClient extends WebChromeClient {

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return super.onConsoleMessage(consoleMessage);
    }
}
