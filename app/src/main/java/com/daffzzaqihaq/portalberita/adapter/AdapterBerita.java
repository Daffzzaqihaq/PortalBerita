package com.daffzzaqihaq.portalberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.daffzzaqihaq.portalberita.MainActivity;
import com.daffzzaqihaq.portalberita.R;
import com.daffzzaqihaq.portalberita.activities.DetailActivity;
import com.daffzzaqihaq.portalberita.model.BeritaModel;
import com.daffzzaqihaq.portalberita.network.ConfigRetrofit;
import com.daffzzaqihaq.portalberita.responseapi.BeritaItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterBerita extends RecyclerView.Adapter<AdapterBerita.ViewHolder> {

    // TODO 4 Membuat variable untuk menampung data yang di butuhkan adapter
    Context context;
    List<BeritaItem> berita;


    public AdapterBerita(Context context, List<BeritaItem> berita) {
        this.context = context;
        this.berita = berita;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.berita_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvJudulBerita.setText(berita.get(i).getJudulBerita());
        viewHolder.tvPenulis.setText(berita.get(i).getPenulis());
        viewHolder.tvTglTerbit.setText(berita.get(i).getTanggalPosting());

        // Mengambil alamat gambar
        final String urlGambarBerita = ConfigRetrofit.API_URL + "images/" + berita.get(i).getFoto();

        // Menampilkan gambar ke layar dengan glide
        Glide.with(context).load(urlGambarBerita).into(viewHolder.ivGambarBerita);

        // Membuat onClick untuk dapat mengklik item
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Membuat object BeritaModel untuk dapat mengisi data ke dalam object berita model
                BeritaModel beritaModel = new BeritaModel();

                // Mengisi data ke dalam object berita model
                beritaModel.setJudul(berita.get(i).getJudulBerita());
                beritaModel.setPenulis(berita.get(i).getPenulis());
                beritaModel.setGambar(urlGambarBerita);
                beritaModel.setTanggalpost(berita.get(i).getTanggalPosting());
                beritaModel.setIsiberita(berita.get(i).getIsiBerita());

                // Berpindah halaman menggunakan Intent
                Intent intent = new Intent(context, DetailActivity.class);

                // Memasukan object beritaMode; yang ada isinya ke dalam putExtra intent untuk di kirim
                intent.putExtra(DetailActivity.EXTRA_OBJ,beritaModel);


                // Menjalankan Intent
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return berita.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ivGambarBerita)
        ImageView ivGambarBerita;
        @BindView(R.id.tvJudulBerita)
        TextView tvJudulBerita;
        @BindView(R.id.tvTglTerbit)
        TextView tvTglTerbit;
        @BindView(R.id.tvPenulis)
        TextView tvPenulis;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }

}
