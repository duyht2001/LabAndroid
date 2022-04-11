package com.example.cntt61.bkt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edTK , edMK;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTK =(EditText) findViewById(R.id.edTK);
        edMK =(EditText) findViewById(R.id.edMK);
        btnLogin =(Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {    
            @Override
            public void onClick(View view) {
                String username = "maicuongtho";
                String password = "Cntt60ntu";
                if(edTK.getText().toString().equals(username) && edMK.getText().toString().equals(password) ){
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"Tài khoản hoặc mật khẩu sai",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}