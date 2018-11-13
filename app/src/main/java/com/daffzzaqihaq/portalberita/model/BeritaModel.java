package com.daffzzaqihaq.portalberita.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BeritaModel implements Parcelable{

    // Membuat variable untuk menampung data yg kita inginkan
    String judul,penulis,tanggalpost,isiberita,gambar;


    // Membuat getter setter berdasarkan variable yg kita inginkan
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTanggalpost() {
        return tanggalpost;
    }

    public void setTanggalpost(String tanggalpost) {
        this.tanggalpost = tanggalpost;
    }

    public String getIsiberita() {
        return isiberita;
    }

    public void setIsiberita(String isiberita) {
        this.isiberita = isiberita;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.penulis);
        dest.writeString(this.tanggalpost);
        dest.writeString(this.isiberita);
        dest.writeString(this.gambar);
    }

    public BeritaModel() {
    }

    protected BeritaModel(Parcel in) {
        this.judul = in.readString();
        this.penulis = in.readString();
        this.tanggalpost = in.readString();
        this.isiberita = in.readString();
        this.gambar = in.readString();
    }

    public static final Creator<BeritaModel> CREATOR = new Creator<BeritaModel>() {
        @Override
        public BeritaModel createFromParcel(Parcel source) {
            return new BeritaModel(source);
        }

        @Override
        public BeritaModel[] newArray(int size) {
            return new BeritaModel[size];
        }
    };
}
