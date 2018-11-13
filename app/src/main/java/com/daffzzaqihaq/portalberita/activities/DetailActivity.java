package com.daffzzaqihaq.portalberita.activities;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daffzzaqihaq.portalberita.R;
import com.daffzzaqihaq.portalberita.model.BeritaModel;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_OBJ = "obj";
    @BindView(R.id.ivGambarBerita)
    ImageView ivGambarBerita;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.tvTglTerbit)
    TextView tvTglTerbit;
    @BindView(R.id.tvPenulis)
    TextView tvPenulis;
    @BindView(R.id.wvContentBerita)
    TextView wvContentBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        // Membuat toolbar actionbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Menangkap data dari intent ke dalam object BeritaModel
        BeritaModel beritaModel = getIntent().getParcelableExtra(EXTRA_OBJ);

        // Memasukan data yang ada di dalam beritaModel ke dalam variable baru
        String judul = beritaModel.getJudul();
        String penulis = beritaModel.getPenulis();
        String tanggalpost = beritaModel.getTanggalpost();
        String isiberita = beritaModel.getIsiberita();
        String gambar = beritaModel.getGambar();

        // Menampilkan judul berita ke dalam title action bar
        getSupportActionBar().setTitle(judul);

        // Menampilkan penulis dan tanggal posting ke layar
        tvPenulis.setText(penulis);
        tvTglTerbit.setText(tanggalpost);

        // Menampilkan gambar
        Glide.with(this).load(gambar).into(ivGambarBerita);

        // Menisi isi berita
        wvContentBerita.setText(isiberita);






    }
}
