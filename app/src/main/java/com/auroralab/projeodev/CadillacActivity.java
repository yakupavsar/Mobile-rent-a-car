package com.auroralab.projeodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadillacActivity extends AppCompatActivity {
    Button button;
    EditText edittext_name;
    EditText edittext_tc;
    EditText edittext_mail;
    EditText edittext_telefon;
    EditText edittext_adres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadillac);

        button = findViewById(R.id.btn);
        edittext_name = findViewById(R.id.edittext_name);
        edittext_tc = findViewById(R.id.edittext_tc);
        edittext_mail = findViewById(R.id.edittext_mail);
        edittext_telefon = findViewById(R.id.edittext_telefon);
        edittext_adres = findViewById(R.id.edittext_adres);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkRegisterInformation();
            }
        });
    }
    private void checkRegisterInformation() {
        String name = edittext_name.getText().toString();
        String tc = edittext_tc.getText().toString();
        String mail = edittext_mail.getText().toString();
        String telefon = edittext_telefon.getText().toString();
        String adres = edittext_adres.getText().toString();


        boolean check =initinfo(name,tc,mail,telefon,adres);

        if (check == true){
            Toast.makeText(getApplicationContext(),"Araç kiralama işleminiz gerçekleşmiştir.",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Eksik alanları tamamlayınız",Toast.LENGTH_LONG).show();
        }
    }
    private Boolean initinfo(String name, String tc, String mail, String telefon, String adres) {
        if (name.length()==0){
            edittext_name.requestFocus();
            edittext_name.setError("Lütfen isim soyisim giriniz.");
            return false;

        }
        else if (!name.matches("[a-zA-Z]+")){
            edittext_name.requestFocus();
            edittext_name.setError("Lütfen geçerli bir isim soyisim giriniz.");
            return false;

        }
        else if (tc.length() != 11){
            edittext_tc.requestFocus();
            edittext_tc.setError("Lütfen 11 haneli kimlik numaranızı giriniz.");
            return false;
        }
        else if(telefon.length() != 10){
            edittext_telefon.requestFocus();
            edittext_telefon.setError("Lütfen başında 0 olmadan telefon numaranızı giriniz." );
            return false;
        }
        else if (mail.length()==0){
            edittext_mail.requestFocus();
            edittext_mail.setError("Lütfen mail adresinizi giriniz");
            return false;
        }
        else if (!mail.matches("[a-zA-Z0-9._ -]+@[a-z]+\\.+[a-z]+")){
            edittext_mail.requestFocus();
            edittext_mail.setError("Lütfen gerçerli mail adresi giriniz");
            return false;
        }
        else {
            return true;
        }
    }

}