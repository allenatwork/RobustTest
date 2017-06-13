package allen.robust.test.api;

import java.util.List;

import allen.robust.test.object.GoldPrice;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by Admin on 9/9/2016.
 */
public interface ApiInterface {
    @Headers("X-App-Token:76524a53ee60602ac3528f38")
    @GET("prices/chart_data")
    Call<List<GoldPrice>> getGoldInfo();
}
