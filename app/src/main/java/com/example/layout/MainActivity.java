package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView date;
    EditText namaDepan,namaBelakang,alamat,email,password,hobby,buah;
    CheckBox checkBox;
    RadioGroup kelamin;
    private Button register;
    private DatePickerDialog.OnDateSetListener mDateListener;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Register");

        date = findViewById(R.id.date);
        register=findViewById(R.id.btn);
        namaDepan=findViewById(R.id.namaDepan);
        namaBelakang=findViewById(R.id.namaBelakang);
        alamat=findViewById(R.id.alamat);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        hobby=findViewById(R.id.hobby);
        buah=findViewById(R.id.buah);
        checkBox=findViewById(R.id.check);
        kelamin=findViewById(R.id.kelamin);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {

                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);
                String datee = month + "/" + day + "/" + year;
                date.setText(datee);

            }
        };
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Depan=namaDepan.getText().toString();
                String belakang=namaBelakang.getText().toString();
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                String tanggal=date.getText().toString();
                String Alamat=alamat.getText().toString();
                String Hobby=hobby.getText().toString();
                String Buah=buah.getText().toString();
                String CheckBox=checkBox.getText().toString();


                if (Depan.isEmpty()||belakang.isEmpty()||Email.isEmpty()||Password.isEmpty()||tanggal.isEmpty()||Alamat.isEmpty()||Hobby.isEmpty()||Buah.isEmpty()){

                    Toast.makeText(MainActivity.this,"No One Can Empty",Toast.LENGTH_SHORT).show();
                }
                if(!(Depan.isEmpty()||belakang.isEmpty()||Email.isEmpty()||Password.isEmpty()||tanggal.isEmpty()||Alamat.isEmpty()||Hobby.isEmpty()||Buah.isEmpty())){
                    startActivity(new Intent(MainActivity.this,Main2Activity.class));
                }

            }
        });


    }


}
