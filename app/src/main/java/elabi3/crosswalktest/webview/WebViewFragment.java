package elabi3.crosswalktest.webview;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import elabi3.crosswalktest.R;

/**
 * Created by elabi3 on 1/5/16.
 **/
public class WebViewFragment extends Fragment {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    public final static String EXTRA_URL = "EXTRA_URL";

    ///////////////////////////////////////////////////////////////////////////
    // Widgets
    ///////////////////////////////////////////////////////////////////////////

    private View mView;
    private WebView webView;


    /**************************************************************************
     * Constructor
     **************************************************************************/

    //region Constructor
    public static WebViewFragment newInstance(String url) {
        Bundle args = new Bundle();

        WebViewFragment fragment = new WebViewFragment();
        args.putString(EXTRA_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    //endregion


    /**************************************************************************
     * LifeCycle
     **************************************************************************/

    //region LifeCycle Methods
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.webview_fragment, container, false);

        configureWebView();

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null && getArguments().getString(EXTRA_URL) != null) {
            loadWebSite(getArguments().getString(EXTRA_URL));
        }
    }

    //endregion

    /**************************************************************************
     * Auxiliar
     **************************************************************************/

    //region LifeCycle
    public void loadWebSite(String url) {
        webView.loadUrl(url);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void configureWebView() {
        webView = (WebView) mView.findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewStandardClient());
        webView.setWebChromeClient(new ChromeClient());

        //webView.setWebContentsDebuggingEnabled(true);
    }

    public void clearCache() {
        webView.clearCache(true);
    }

    //endregion
}