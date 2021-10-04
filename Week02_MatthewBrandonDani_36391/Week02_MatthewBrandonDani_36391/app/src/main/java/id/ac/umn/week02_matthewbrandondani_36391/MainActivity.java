package id.ac.umn.week02_matthewbrandondani_36391;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText angka1, angka2;
    TextView hasil;
    Button tomboltambah,tombolkurang, tombolkali, tombolbagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angka1 = this.findViewById(R.id.angka1);
        angka2 = this.findViewById(R.id.angka2);
        hasil = this.findViewById(R.id.hasil);
        tomboltambah = this.findViewById(R.id.tomboltambah);
        tombolkurang = this.findViewById(R.id.tombolkurang);
        tombolkali = this.findViewById(R.id.tombolkali);
        tombolbagi = this.findViewById(R.id.tombolbagi);
        tomboltambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('+');
            }
        });
        tombolkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('-');
            }
        });
        tombolkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('*');
            }
        });
        tombolbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hitung('/');
            }
        });
    }
    protected void hitung(char operator){
        if(!angka1.getText().toString().isEmpty() && !angka2.getText().toString().isEmpty() && Double.parseDouble(angka2.getText().toString())!= 0){
            double operand1 = Double.parseDouble(angka1.getText().toString());
            double operand2 = Double.parseDouble(angka2.getText().toString());
            double result = 0.0;
            switch(operator){
                case('+') : result = operand1 + operand2; break;
                case('-') : result = operand1 - operand2; break;
                case('*') : result = operand1 * operand2; break;
                case('/') : result = operand1 / operand2; break;
            }
            hasil.setText(String.valueOf(result));
        }else if(angka1.getText().toString().isEmpty()){
            hasil.setText("angka 1 kosong");
        }else if(angka2.getText().toString().isEmpty()) {
            hasil.setText("angka 2 kosong");
        }else if(Double.parseDouble(angka2.getText().toString())== 0) {
            hasil.setText("Error Pembagian");
        }
    }
}