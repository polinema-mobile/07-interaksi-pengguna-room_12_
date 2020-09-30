package com.example.activityintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  {
    EditText nama, nim, tanggalLahir;
    Spinner jurusan;
    RadioGroup jeniskelamin;
    RadioButton lakilaki, perempuan;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nama = (EditText) findViewById(R.id.edtNama);
        final EditText nim = (EditText) findViewById(R.id.edtNim);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tanggalLahir = (EditText) findViewById(R.id.edtTanggalLahir);
        tanggalLahir.setInputType(InputType.TYPE_NULL);
        tanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        RadioButton lakilaki = (RadioButton) findViewById(R.id.radioLakilaki);
        RadioButton perempuan = (RadioButton) findViewById(R.id.radioPerempuan);

        jeniskelamin = (RadioGroup) findViewById(R.id.radioGroup);
        jeniskelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radioLakilaki:
                        gender  = "Laki-Laki";
                        break;
                    case R.id.radioPerempuan:
                        gender = "Perempuan";
                        break;
                }
            }
        });

        jurusan = (Spinner) findViewById(R.id.listJurusan);
        jurusan.setOnItemSelectedListener(new ItemSelectedListener());

        Button button = findViewById(R.id.btnSimpan);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityKedua.class);

                int id = jeniskelamin.getCheckedRadioButtonId();
                RadioButton selectedGender = (RadioButton) findViewById(id);

                //Menyisipkan tipe data String ke dalam obyek bundle
                intent.putExtra("nama", nama.getText().toString());
                intent.putExtra("nim", nim.getText().toString());
                intent.putExtra("tanggalLahir", tanggalLahir.getText().toString());
                intent.putExtra("jeniskelamin", gender);
                intent.putExtra("jurusan", jurusan.getSelectedItem().toString());

                //memulai Activity kedua
                startActivity(intent);
            }
        });
    }

    private void showDateDialog(){
        //Calendar untuk mendapatkan tanggal sekarang
        Calendar newCalendar = Calendar.getInstance();

        //Initiate DatePicker dialog
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                //Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                //Set Calendar untuk menampung tanggal yang dipilih
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                //Update TextView dengan tanggal yang kita pilih
                tanggalLahir.setText(dateFormatter.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        //Tampilkan DatePicker dialog
        datePickerDialog.show();
    }

    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(jurusan.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            firstItem.equals(String.valueOf(jurusan.getSelectedItem())); {

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

}