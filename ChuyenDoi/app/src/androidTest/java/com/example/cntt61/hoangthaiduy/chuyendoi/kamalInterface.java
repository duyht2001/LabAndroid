package com.example.cntt61.hoangthaiduy.chuyendoi;
import com.google.gson.JsonObject;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface kamalInterface {
    @GET("v6/1929988978e7cd9733e5e654/latest/{currency}")
    Call<JsonObject> getExchangeCurrency(@Path("currency") String currency);
}
