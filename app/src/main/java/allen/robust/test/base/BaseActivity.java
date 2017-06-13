package allen.robust.test.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import allen.robust.test.util.AndroidUtils;


public abstract class BaseActivity extends AppCompatActivity {
    private final String TagActivity = this.getClass().getCanonicalName();
    protected boolean mPaused;

    private ProgressDialog mProgressDialog;

    protected abstract int getLayoutResource();

    protected abstract int getContainerId();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
    }


    @Override
    protected void onPause() {
        super.onPause();
        mPaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPaused = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            View view = this.getWindow().getDecorView().findViewById(android.R.id.content);
            AndroidUtils.cleanView(view);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

