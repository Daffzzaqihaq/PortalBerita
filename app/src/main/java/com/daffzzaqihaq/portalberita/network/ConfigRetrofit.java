package com.daffzzaqihaq.portalberita.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {

    public static final String API_URL = "http://192.168.71.96/portal_beritar/";
    // TODO 1 Mensetting retrofit
    // Setting alamat web service atau API
    // add covert gson
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // TODO 2 Membuat object service api dengan retrofit
    public APIService service = retrofit.create(APIService.class);
}
