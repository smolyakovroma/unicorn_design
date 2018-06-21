package android.test.web3j;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RestApi {

//    @POST("/v1/auth/login")
//    Call<Auth> login(@Body Login body);

    @POST("/v1/profile/")
    Call<User> profile(@Header("X-Auth-Token") String auth, @Body HashMap<String, String> body);

//    @PUT("/v1/profile/{id}")
//    Call<User> profileUpdate(@Header("X-Auth-Token") String auth, @Path("id") String id, @Body Profile body);

    @POST("/v1/unicorn/get")
    Call<Unicorns> getUnicorns(@Header("X-Auth-Token") String auth, @Body FilterUnicorns body);

//    @PUT("/v1/unicorn/{id}")
//    Call<Unicorn> updateUnicorn(@Header("X-Auth-Token") String auth, @Path("id") String id, @Body Update update);

    @GET("/v1/unicorn/one/{id}")
    Call<Unicorn> oneUnicorn(@Header("X-Auth-Token") String auth, @Path("id") String id);

    @POST("/v1/unicorn/like/{id}")
    Call<Unicorn> like(@Header("X-Auth-Token") String auth, @Path("id") String id);

    @POST("/v1/unicorn/unlike/{id}")
    Call<Unicorn> unlike(@Header("X-Auth-Token") String auth, @Path("id") String id);

    @POST("/v1/unicorn/view/{id}")
    Call<Unicorn> view(@Header("X-Auth-Token") String auth, @Path("id") String id);

//    @GET("/api/gasPriceOracle")
//    Call<GasPriceOracle> getGasPriceOracle();

    @FormUrlEncoded
    @POST("/unicorn/{id}")
    Call<Void> renderPic(@Path("id") String id, @Field("chain") String chain);

//    @GET("/api?module=account&action=txlist&startblock=0&endblock=99999999&sort=asc")
//    Call<AllTransaction> getAllTransactions(@Query("address") String address, @Query("apikey") String apikey);
//    @GET("/v1/ticker/{coin}")
//    Call<List<Rate>> getRate(@Path("coin") String coin, @Query("convert") String convert);
//
//    @GET("/srv/api/user")
//    Call<User> getUser(@Query("apikey") String apikey);
//
//    @GET("/srv/api/workers")
//    Call<List<Worker>> getWorkers(@Query("apikey") String apikey);
}
