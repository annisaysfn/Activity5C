package com.example.sampleconstraintlayout;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityKedua extends AppCompatActivity {
    //Mendeklarasikan variabel dengan tipe data TextView
    TextView txEmail, txPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);

        //Menghubungkan variabel txEmail dengan komponen TextView pada layout
        txEmail = findViewById(R.id.tvEmail);

        //Menghubungkan variabel txPassword dengan komponen TextView pada Layout
        txPassword = findViewById(R.id.tvPassword);

        //Mendeklarasikan variabel bundle yang akan digunakan untuk mengambil
        //pesan yang dikirimkan melalui metode intent
        Bundle bundle = getIntent().getExtras();

        //Membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "a"
        String email = bundle.getString("a");

        //Membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari activity sebelumnya dengan kunci "b"
        String pass = bundle.getString("b");

        //Menampilkan value dari variabel email ke dalam txEmail
        txEmail.setText(email);

        //Menampilkan value dari variabel pass ke dalam txPassword
        txPassword.setText(pass);
    }
}
