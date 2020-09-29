package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityKedua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        Bundle b = getIntent().getExtras();
        //membuat obyek dari widget textview
        TextView nama = (TextView) findViewById(R.id.edtNama);
        TextView nim = (TextView) findViewById(R.id.edtNIM);
        TextView tanggalLahir = (TextView) findViewById(R.id.edtTanggalLahir);
        TextView jeniskelamin = (TextView) findViewById(R.id.edtJenisKelamin);
        TextView jurusan = (TextView) findViewById(R.id.edtJurusan);
        //menset nilai dari widget textview
        nama.setText(b.getCharSequence("nama"));
        nim.setText(b.getCharSequence("nim"));
        tanggalLahir.setText(b.getCharSequence("tanggalLahir"));
        jeniskelamin.setText(b.getCharSequence("jeniskelamin"));
        jurusan.setText(b.getCharSequence("jurusan"));

    }
}