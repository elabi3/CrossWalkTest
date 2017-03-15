package elabi3.crosswalktest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import elabi3.crosswalktest.crosswalk.XwalkFragment;
import elabi3.crosswalktest.webview.WebViewFragment;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {


    /**************************************************************************
     * LifeCycle
     **************************************************************************/

    //region LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timber.plant(new Timber.DebugTree());

        loadXWalk();
        //loadStandardWebView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    //endregion


    /**************************************************************************
     * Auxiliar
     **************************************************************************/

    //region Auxiliar
    private void loadXWalk() {
        Fragment fragment = XwalkFragment.newInstance("https://chromium.github.io/octane/");
        //Fragment fragment = XwalkFragment.newInstance("http://www.wirple.com/bmark/");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    private void loadStandardWebView() {
        Fragment fragment = WebViewFragment.newInstance("https://chromium.github.io/octane/");
        //Fragment fragment = WebViewFragment.newInstance("http://www.wirple.com/bmark/");

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_content, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }

    //endregion
}
