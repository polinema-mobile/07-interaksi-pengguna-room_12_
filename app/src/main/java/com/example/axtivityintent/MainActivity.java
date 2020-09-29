package com.example.axtivityintent;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private EditText nama, nim, tanggalLahir;
    private Button btnSimpan;
    private Spinner spinner1;
    private RadioGroup jurusan;
    private RadioButton lakilaki, perempuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        tanggalLahir = (EditText) findViewById(R.id.edtTanggalLahir);
        tanggalLahir.setInputType(InputType.TYPE_NULL);
        tanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner1.setOnItemSelectedListener(new ItemSelectedListener());

        jurusan = (RadioGroup) findViewById(R.id.edtRadio);
        lakilaki = (RadioButton) findViewById(R.id.radioLakilaki);
        perempuan = (RadioButton) findViewById(R.id.radioPerempuan);

        btnSimpan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), ActivityKedua.class);
        //Membuat obyek bundle
        Bundle b = new Bundle();

        //Menyisipkan tipe data String ke dalam obyek bundle
        b.putString("Nama", nama.getText().toString());
        b.putString("NIM", nim.getText().toString());
        b.putString("Tanggal Lahir", tanggalLahir.getText().toString());
        int id = jurusan.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(id);
        b.putString("Jenis Kelamin", radioButton.getText().toString());

        //Menambahkan bundle intent
        intent.putExtras(b);

        //memulai Activity kedua
        startActivity(intent);
        }


    public class ItemSelectedListener implements AdapterView.OnItemSelectedListener {

        //get strings of first item
        String firstItem = String.valueOf(spinner1.getSelectedItem());

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            if (firstItem.equals(String.valueOf(spinner1.getSelectedItem()))) {
                // ToDo when first item is selected
            } else {
                Toast.makeText(parent.getContext(),
                       parent.getItemAtPosition(pos).toString(),
                        Toast.LENGTH_LONG).show();
                // Todo when item is selected by the user
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private void showDateDialog() {

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

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        //Tampilkan DatePicker dialog

        datePickerDialog.show();
    }
}