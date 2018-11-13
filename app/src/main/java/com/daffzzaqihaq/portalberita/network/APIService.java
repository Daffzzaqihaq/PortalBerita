package com.daffzzaqihaq.portalberita.network;

import com.daffzzaqihaq.portalberita.responseapi.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    // TODO 3 Merequest Data dan mengambil data berita
    @GET("tampil_berita.php")
    Call<ResponseBerita> getAllBerita();
}
