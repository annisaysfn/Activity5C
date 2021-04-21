package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan komponen button pada layout
        btnLogin = findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan komponen button pada layout
        edemail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan komponen button pada layout
        edpassword = findViewById(R.id.edPassword);

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();

                //Menyimpan input user di edittext password ke dalam variabel password
                password = edpassword.getText().toString();

                //Mengeset email yang benar
                String email = "admin@mail.com";

                //Mengeset password yang benar
                String pass = "123";

                //Mengecek apakah edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //Membuat variabel toast dan menampilkan pesan "editText tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(), "Email dan Password wajib diisi!", Toast.LENGTH_LONG);

                    //Menampilkan toast
                    t.show();
                } else {

                    //Mengecek apakah isi dari email dan password sudah sama dengan email dan
                    //password yang sudah di set
                    if (nama.equals(email) && password.equals(pass)) {   //Membuat variabel toast dan menampilkan pesan "Login sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Berhasil", Toast.LENGTH_LONG);
                        //Menampilkan toast
                        t.show();

                        //Membuat objek bundle
                        Bundle b = new Bundle();

                        //Memasukkan value dari variabel nama dengan kunci "a"
                        //dan dimasukan ke dalam bundle
                        b.putString("a", nama.trim());

                        //Memasukkan value dari variabel password dengan kunci "b"
                        //dan dimasukkan ke dalam bundle
                        b.putString("b", password.trim());

                        //Membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHome.class);

                        //Memasukkan bundle ke dalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);

                        //Berpindah ke ActivityHasil
                        startActivity(i);
                    } else {
                        //Membuat variabel toast dan membuat toast dan menampilkan pesan "Login gagal"

                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);

                        //Menampilkan toast
                        t.show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Membuat kondisi jika yang dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "ActivityDaftar"
            Intent i = new Intent(getApplicationContext(), ActivityDaftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}