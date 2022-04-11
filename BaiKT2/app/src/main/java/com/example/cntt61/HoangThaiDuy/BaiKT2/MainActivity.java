package com.example.cntt61.HoangThaiDuy.BaiKT2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton r_13, r_15, r_18;
    Button tinh;
    EditText bp;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bp=(EditText) findViewById(R.id.edtN);
        textView=(TextView) findViewById(R.id.tvkq1);
        r_13=(RadioButton) findViewById(R.id.radio_13);
        r_15=(RadioButton) findViewById(R.id.radio_15);
        r_18=(RadioButton) findViewById(R.id.radio_18);
        tinh=(Button) findViewById(R.id.btntinh);
        tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float nhap=Float.parseFloat(bp.getText().toString());
                if(r_13.isChecked()){
                    float tt= (float) (nhap*0.13);
                    textView.setText("Your tip will be $"+tt);
                    Toast.makeText(MainActivity.this, "Your tip will be $"+tt, Toast.LENGTH_SHORT).show();
                }
                else if(r_15.isChecked()){
                    float tt= (float) (nhap*0.15);
                    textView.setText("Your tip will be $"+tt);
                    Toast.makeText(MainActivity.this, "Your tip will be $"+tt, Toast.LENGTH_SHORT).show();
                }
                else if(r_18.isChecked()){
                    float tt= (float) (nhap*0.18);
                    textView.setText("Your tip will be $"+tt);
                    Toast.makeText(MainActivity.this, "Your tip will be $"+tt, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}