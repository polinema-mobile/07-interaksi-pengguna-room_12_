package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Parcel;
import android.os.Parcelable;

public class Biodata extends AppCompatActivity implements Parcelable {

    String nama, nim, tanggalLahir, jenisKelamin, jurusan;

    protected Biodata(Parcel in) {
        nama = in.readString();
        nim = in.readString();
        tanggalLahir = in.readString();
        jurusan = in.readString();
        jenisKelamin = in.readString();
    }
    public Biodata(String nama, String nim, String tanggalLahir, String jurusan, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.tanggalLahir = tanggalLahir;
        this.jurusan = jurusan;
        this.jenisKelamin = jenisKelamin;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(nim);
        dest.writeString(tanggalLahir);
        dest.writeString(jenisKelamin);
        dest.writeString(jurusan);
    }

    public static final Parcelable.Creator<Biodata> CREATOR = new Parcelable.Creator<Biodata>() {
        @Override
        public Biodata createFromParcel(Parcel source) {
            return new Biodata(source);
        }

        @Override
        public Biodata[] newArray(int size) {
            return new Biodata[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public static Creator<Biodata> getCREATOR() {
        return CREATOR;
    }
}

