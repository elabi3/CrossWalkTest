package elabi3.crosswalktest.crosswalk;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.xwalk.core.XWalkPreferences;
import org.xwalk.core.XWalkView;

import java.io.File;

import elabi3.crosswalktest.R;

/**
 * Created by elabi3 on 29/4/16.
 **/
public class XwalkFragment extends Fragment {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    public final static String EXTRA_URL = "EXTRA_URL";

    ///////////////////////////////////////////////////////////////////////////
    // Widgets
    ///////////////////////////////////////////////////////////////////////////

    private View mView;
    private XWalkView xWalkView;

    /**************************************************************************
     * Constructor
     **************************************************************************/

    //region Constructor
    public static XwalkFragment newInstance(String url) {
        Bundle args = new Bundle();

        XwalkFragment fragment = new XwalkFragment();
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
        mView = inflater.inflate(R.layout.xwalk_fragment, container, false);

        configureXwalkView();

        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null && getArguments().getString(EXTRA_URL) != null) {
            loadWebSite(getArguments().getString(EXTRA_URL));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        xWalkView.onDestroy();
    }

    //endregion

    /**************************************************************************
     * Auxiliar
     **************************************************************************/

    //region LifeCycle
    public void loadWebSite(String url) {
        xWalkView.load(url, null);
    }

    private void configureXwalkView() {
        xWalkView = (XWalkView) mView.findViewById(R.id.xwalkWebView);

        xWalkView.setResourceClient(new ResourceClient(xWalkView));
        xWalkView.setUIClient(new UIClient(xWalkView));

        XWalkPreferences.setValue(XWalkPreferences.REMOTE_DEBUGGING, true);
    }

    public void clearCache() {
        xWalkView.clearCache(true);
        File cacheDir = new File(getActivity().getDir("app_xwalkcore", Context.MODE_PRIVATE), "Default/Cache");
        deleteRecursive(cacheDir);
    }

    private void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }
        fileOrDirectory.delete();
    }

    //endregion
}