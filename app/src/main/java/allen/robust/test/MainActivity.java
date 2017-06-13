package allen.robust.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import allen.robust.test.api.ApiInterface;
import allen.robust.test.api.RetrofitSingleton;
import allen.robust.test.base.BaseActivity;
import allen.robust.test.object.GoldPrice;
import allen.robust.test.screen.home.ListGoldPriceAdapter;
import allen.robust.test.util.LogUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity {

    private ApiInterface apiInterface;
    RecyclerView rvGoldInfo;

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_main;
    }

    @Override
    protected int getContainerId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rvGoldInfo = (RecyclerView) findViewById(R.id.rvGoldInfo);
        rvGoldInfo.setLayoutManager(new LinearLayoutManager(this));
        apiInterface = RetrofitSingleton.getApiService();
        Call<List<GoldPrice>> getGoldInfo = apiInterface.getGoldInfo();
        getGoldInfo.enqueue(new Callback<List<GoldPrice>>() {
            @Override
            public void onResponse(Call<List<GoldPrice>> call, Response<List<GoldPrice>> response) {
                LogUtils.logD("Size" + response.body().size());
                bindData (response.body());
            }

            @Override
            public void onFailure(Call<List<GoldPrice>> call, Throwable t) {
                LogUtils.logD("Call failure");
            }
        });
    }

    private void bindData(final List<GoldPrice> listData) {
        if (listData == null) return; // Todo: should show empty screen here
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ListGoldPriceAdapter adapter = new ListGoldPriceAdapter(listData);
                rvGoldInfo.setAdapter(adapter);
            }
        });


    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }
}
