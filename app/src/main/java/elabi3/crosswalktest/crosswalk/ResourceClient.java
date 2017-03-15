package elabi3.crosswalktest.crosswalk;

import android.net.http.SslError;
import android.webkit.ValueCallback;

import org.xwalk.core.ClientCertRequest;
import org.xwalk.core.XWalkHttpAuthHandler;
import org.xwalk.core.XWalkResourceClient;
import org.xwalk.core.XWalkView;
import org.xwalk.core.XWalkWebResourceRequest;
import org.xwalk.core.XWalkWebResourceResponse;

import timber.log.Timber;

/**
 * Created by elabi3 on 29/4/16.
 **/
public class ResourceClient extends XWalkResourceClient {

    /**************************************************************************
     * Constructor
     **************************************************************************/

    //region Constructor
    public ResourceClient(XWalkView view) {
        super(view);
    }

    //endregion


    /**************************************************************************
     * WebCycle
     **************************************************************************/

    //region WebCycle
    @Override
    public void onLoadStarted(XWalkView view, String url) {
        super.onLoadStarted(view, url);
        Timber.d("onLoadStarted: " + url);
    }

    @Override
    public void onLoadFinished(XWalkView view, String url) {
        super.onLoadFinished(view, url);
        Timber.d("onLoadFinished: " + url);
    }

    @Override
    public void onDocumentLoadedInFrame(XWalkView view, long frameId) {
        super.onDocumentLoadedInFrame(view, frameId);
    }

    @Override
    public void onProgressChanged(XWalkView view, int progressInPercent) {
        super.onProgressChanged(view, progressInPercent);
    }

    @Override
    public void onReceivedResponseHeaders(XWalkView view, XWalkWebResourceRequest request, XWalkWebResourceResponse response) {
        super.onReceivedResponseHeaders(view, request, response);
    }

    //endregion


    /**************************************************************************
     * Request
     **************************************************************************/

    //region Request
    @Override
    public void onReceivedClientCertRequest(XWalkView view, ClientCertRequest handler) {
        super.onReceivedClientCertRequest(view, handler);
    }

    @Override
    public void onReceivedHttpAuthRequest(XWalkView view, XWalkHttpAuthHandler handler, String host, String realm) {
        super.onReceivedHttpAuthRequest(view, handler, host, realm);
    }

    //endregion


    /**************************************************************************
     * Errors
     **************************************************************************/

    //region Errors
    @Override
    public void onReceivedLoadError(XWalkView view, int errorCode, String description, String failingUrl) {
        super.onReceivedLoadError(view, errorCode, description, failingUrl);
    }

    @Override
    public void onReceivedSslError(XWalkView view, ValueCallback<Boolean> callback, SslError error) {
        super.onReceivedSslError(view, callback, error);
    }

    //endregion
}
