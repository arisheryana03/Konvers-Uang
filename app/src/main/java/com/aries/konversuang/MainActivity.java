package com.aries.konversuang;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText input_uang;
    Button rp_usd, rp_euro, rp_yen;
    TextView hasil_konversi;

    double angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_uang = (EditText) findViewById(R.id.uang_input);
        rp_usd = (Button) findViewById(R.id.rpusd);
        rp_euro = (Button) findViewById(R.id.rpeuro);
        rp_yen = (Button) findViewById(R.id.rpyen);
        hasil_konversi = (TextView) findViewById(R.id.hasil_konversi);
    }


    public boolean cek() {
        if (input_uang.getText().toString().isEmpty()) {
            Toast.makeText(this, "Silahkan masukan jumlah uang", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void toYEN(View v) {
        if (!cek()) {
            return;
        }

        try {
            angka = Double.parseDouble(input_uang.getText().toString());
        } catch (Exception ex) {
            Toast.makeText(this, "Masukan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 134.69;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.JAPAN).format(hasil));
        Toast.makeText(this, "1 Yen = Rp 134.69", Toast.LENGTH_SHORT).show();
    }

    public void toEuro(View v) {
        if (!cek()) {
            return;
        }

        try {
            angka = Double.parseDouble(input_uang.getText().toString());
        } catch (Exception ex) {
            Toast.makeText(this, "Masukan angka", Toast.LENGTH_SHORT).show();
        }

        double  hasil = angka / 16184.25;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil));
        Toast.makeText(this, "1 Euro = 16184.25", Toast.LENGTH_SHORT).show();
    }

    public void toUSD(View view) {
        if (!cek()) {
            return;
        }

        try {
            angka = Double.parseDouble(input_uang.getText().toString());
        } catch (Exception ex) {
            Toast.makeText(this, "Masukan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 14612;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.US).format(hasil));
        Toast.makeText(this, "1 U$D = 14612", Toast.LENGTH_SHORT).show();
    }
}
