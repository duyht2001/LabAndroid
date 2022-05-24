package com.example.chuvidientich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText canhben, canhday, chieucao;
    TextView KQ;
    Button chuvi;
    Button dientich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        canhben=(EditText) findViewById(R.id.ben);
        canhday=(EditText) findViewById(R.id.day);
        chieucao=(EditText) findViewById(R.id.cao);
        chuvi=(Button) findViewById(R.id.chuvi);
        dientich=(Button) findViewById(R.id.dientich);
        KQ=(TextView) findViewById(R.id.KQ);
    }
    public void setChuvi(View v){
        float Cben=Float.parseFloat(canhben.getText().toString());
        float Cday=Float.parseFloat(canhday.getText().toString());
        float KetQua;
        KetQua = 2*(Cben+Cday);
        KQ.setText(String.valueOf(KetQua));

    }
    public void setDientich(View v){
        float Ccao=Float.parseFloat(chieucao.getText().toString());
        float Cday=Float.parseFloat(canhday.getText().toString());
        float KetQua;
        KetQua = Ccao*Cday;
        KQ.setText(String.valueOf(KetQua));

    }
}