package com.shon.evaluacionfinal.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static Retrofit instance;

    public static ShowsInterface service;


    public RetrofitHelper(){

    }

    public static Retrofit getInstance(){

        if (instance == null){
            Retrofit  retrofit = new Retrofit.Builder()
           //https://run.mocky.io/v3/1bf8d6b8-edc8-474a-9245-eec80e9bc0ba
                    .baseUrl("https://run.mocky.io/v3/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(getLogginBuilder().build())
                            .build();
            instance = retrofit;

        }  return instance;
    }

    public static OkHttpClient.Builder getLogginBuilder(){
        HttpLoggingInterceptor interceptor  = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);
        return builder;

    }

    public static ShowsInterface getService(){

        if(service == null){
            service = getInstance().create(ShowsInterface.class);
        }
        return service;
    }

}

