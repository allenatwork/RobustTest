package allen.robust.test.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import allen.robust.test.MainActivity;
import allen.robust.test.api.ApiInterface;

public abstract class BaseFragment extends Fragment implements Toolbar.OnMenuItemClickListener {


    private final String TAG = this.getClass().getCanonicalName();
    protected boolean mPaused;
    protected View errorView;
    protected Context mContext;
    protected MainActivity mActivity;

    protected ApiInterface mApi;

    protected abstract int getLayoutResource();

    protected abstract boolean isHasMenu();

    protected abstract int getMenuResource();

    protected void tryAgain() {
        errorView.setVisibility(View.GONE);
    }

    public String getScreenTitle() {
        return "";
    }

    protected final boolean isFragmentValid() {
        return isVisible() && isAdded() && isResumed() && !isRemoving() && !isDetached();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(isHasMenu());
        super.onViewCreated(view, savedInstanceState);

    }




    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        if (isHasMenu()) {
            inflater.inflate(getMenuResource(), menu);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        if (context instanceof MainActivity) {
            mActivity = (MainActivity) context;
        }
    }


    @Override
    public void onDetach() {
        if (mActivity != null) {
        }
        super.onDetach();
        mContext = null;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResource(), container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mApi = mActivity.getApiInterface() ;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void onResume() {
        super.onResume();
        mPaused = false;
    }

    @Override
    public void onPause() {
        super.onPause();
        mPaused = true;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

}
