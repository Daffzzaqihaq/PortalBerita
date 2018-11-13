package com.daffzzaqihaq.portalberita;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;
import android.widget.Toast;

import com.daffzzaqihaq.portalberita.adapter.AdapterBerita;
import com.daffzzaqihaq.portalberita.network.APIService;
import com.daffzzaqihaq.portalberita.network.ConfigRetrofit;
import com.daffzzaqihaq.portalberita.responseapi.BeritaItem;
import com.daffzzaqihaq.portalberita.responseapi.ResponseBerita;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvListBerita)
    RecyclerView rvListBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        
        tampilBerita();

    }

    private void tampilBerita() {
        // Kita buat progress dialog
        final ProgressDialog dialog = ProgressDialog.show(MainActivity.this, "", "loading");

        // TODO 6 Membuat object configretrofit dan ApiService untuk dapat merequesr ke API
        ConfigRetrofit config = new ConfigRetrofit();
        APIService api = config.service;

        // Kirim request
        api.getAllBerita().enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                Log.i("sukses",response.message());

                // Cek response sukses
                if (response.isSuccessful()){
                    // Mematikan progress dialog karena respon server sukses
                    dialog.dismiss();

                    // Menampung isStatus ke dalam variable status
                    boolean status = response.body().isStatus();

                    // Apabila response status true
                    if (status){
                        // Tampung data body ke dalam variable dataSemua
                        ResponseBerita dataSemua = response.body();

                        // Tampung data berita ke dalam variable data berita
                        List<BeritaItem> data_berita = dataSemua.getBerita();

                        // Buat object adapter
                        AdapterBerita adapterBerita = new AdapterBerita(MainActivity.this, data_berita);

                        // setting recycleview
                        rvListBerita.setHasFixedSize(true);
                        // setting style layout recycleview menjadi linear
                        rvListBerita.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                        // Masukan adapter ke recycleview
                        rvListBerita.setAdapter(adapterBerita);

                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {

            }
        });
    }
}
