package com.shon.evaluacionfinal.data.retrofit;

import com.shon.evaluacionfinal.data.response.ShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShowsInterface {
    @GET("1bf8d6b8-edc8-474a-9245-eec80e9bc0ba")
    Call<ShowResponse> getShows();
}
