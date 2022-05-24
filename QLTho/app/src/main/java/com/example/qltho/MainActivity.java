package com.example.qltho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.FocusFinder;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase  databaseBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Tạo mới/mở CSDL
        ///data/data/ntu.bookman
        databaseBook = SQLiteDatabase.openOrCreateDatabase("/data/data/Tho",null);
        // Ta che hàm sau lại, ở những lần chạy sau
        // vì ta không muốn tạo CDSL lại từ đầu
        // TaoBangVaThemDuLieu();
        // ThemMoiSach(10,"Mạng máy tính",50,10,"Sách về Mạng");
        //
        // CapNhat(2,"Lập trình A đây rồi", 100, 500,"Sách quí");
        NapSACHvaoListview();
        Button nutThem= (Button) findViewById(R.id.btnThem);
        Button nutSua= (Button) findViewById(R.id.btnSua);
        Button nutXoa= (Button) findViewById(R.id.btnXoa);
        EditText edChon = (EditText) findViewById(R.id.edtMaCHON);
        // Xử lý
        nutXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String maSach = edChon.getText().toString();
                int ma = Integer.parseInt(maSach);
                XoaSach(ma);
            }
        });
        nutSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy mã sách vừa chọn
                String maSach = edChon.getText().toString();
                // Tạo intent
                Intent intentSua = new Intent();
                // gói dữ liệu
                intentSua.putExtra("masach",maSach);
                // Khởi động SuaACtivity
                startActivity(intentSua);
            }
        });
        nutThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentThem = new Intent();
                startActivity(intentThem);
            }
        });



    }
    void ThemTho(int ma, String ten, String tacgia, float gia, String baitho) {
//        String sqlThem= "INSERT INTO BOOKS VALUES( " +  ma  + "," +
//                                                    "'" + ten + "'," +
//                                                    sotrang + "," +
//                                                    gia + "," +
//                                                    "'" + mota + "')";
//        databaseBook.execSQL(sqlThem);
        ContentValues row = new ContentValues();
        // put (key, value)     key=tên cột, value= giá trị
        row.put("BookID",ma);
        row.put("BookName", ten);
        row.put("Tacgia", tacgia);
        row.put("Price", gia);
        row.put("Description", baitho);
        long kq=  databaseBook.insert("THO",null, row);
        if (kq ==-1)
            Toast.makeText(this, "Không thêm được",Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "Đã thêm thành công",Toast.LENGTH_LONG).show();
        }

    }
    void XoaTho(int ma) {
        String[] thamSoTruyen={String.valueOf(ma)};
        int kq = databaseBook.delete("THO","BookID=?",thamSoTruyen);
        if (kq ==0)
            Toast.makeText(this, "Không xóa  được",Toast.LENGTH_LONG).show();
        else
        {
            Toast.makeText(this, "Xóa thành công",Toast.LENGTH_LONG).show();
        }
    }


    //================================================
    void TaoBangVaThemDuLieu() {
        //Lệnh tạo bảng
        // sqlXoaBang nếu đã có
        String sqlXoaBang ="DROP TABLE IF EXISTS BOOKS";
        databaseBook.execSQL(sqlXoaBang);
        String sqlTaoBang ="CREATE TABLE THO(     BookID integer PRIMARY KEY, " +
                "   BookName text, " +
                "   TacGia text, "+
                "   Price Float, "+
                "   BaiTho text)";
        databaseBook.execSQL(sqlTaoBang);
        // Thêm bản ghi
        String sqlThem1= "INSERT INTO BOOKS VALUES(1, 'QueHuong', 'NguyenTien', 9.99, 'aiyeudatnuoctoi')";
        databaseBook.execSQL(sqlThem1);
        String sqlThem2= "INSERT INTO BOOKS VALUES(2, 'DatNuoc', 'NamCao', 19.00, 'iloveu')";
        databaseBook.execSQL(sqlThem2);
        String sqlThem3= "INSERT INTO BOOKS VALUES(3, 'VietNamquetoi', 'QuanNguyen', 0.99, 'sách đọc cho vui') ";
        databaseBook.execSQL(sqlThem3);

    }
}