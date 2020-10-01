package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class BiodataParcelable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata_parcelable);

        TextView nama = (TextView) findViewById(R.id.edtNama);
        TextView nim = (TextView) findViewById(R.id.edtNIM);
        TextView tanggal = (TextView) findViewById(R.id.edtTanggalLahir);
        TextView jk = (TextView) findViewById(R.id.edtJenisKelamin);
        TextView jurusan = (TextView) findViewById(R.id.edtJurusan);

        Biodata biodata = getIntent().getParcelableExtra("Parcelable");

        nama.setText( biodata.getNama());
        nim.setText(biodata.getNim());
        tanggal.setText(biodata.getTanggalLahir());
        jk.setText (biodata.getJenisKelamin());
        jurusan.setText(biodata.getJurusan());
    }
}