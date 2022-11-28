package com.example.tranvanhuong_kiemtraso3_th;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMayTinh;
    ArrayList<MayTinh> arrayMayTinh;
    MayTinhAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        adapter =new MayTinhAdapter(this, R.layout.dongmaytinh, arrayMayTinh);
        lvMayTinh.setAdapter(adapter);


        lvMayTinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, Profile.class));
                }
            }
        });
        lvMayTinh.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder alertDialogBuilder =new AlertDialog.Builder(MainActivity.this);
                alertDialogBuilder.setMessage("Bán có muốn xóa không !");
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // xóa sp đang nhấn giữ
                        arrayMayTinh.remove(i);
                        //cập nhật lại listview
                        adapter.notifyDataSetChanged();

                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //không làm gì
                    }
                });
                alertDialogBuilder.show();

                return false;
            }
        });
    }
    private void AnhXa () {
        lvMayTinh = (ListView) findViewById(R.id.listviewFriend);
        arrayMayTinh = new ArrayList<>();
        arrayMayTinh.add(new MayTinh("Phép Cộng", "Cộng 2 số", R.drawable.h1));
        arrayMayTinh.add(new MayTinh("Phép Trừ ", "Trừ 2 số ", R.drawable.h2));
        arrayMayTinh.add(new MayTinh("Phép Nhân", "Nhân 2 số ", R.drawable.h3));
        arrayMayTinh.add(new MayTinh("Phép chia", "Chia 2 số ", R.drawable.h4));
        arrayMayTinh.add(new MayTinh("Logarit", "Logaririt ", R.drawable.h5));
        arrayMayTinh.add(new MayTinh("Bình Phương 2 số", "Hằng Đẳng thức", R.drawable.h6));
        arrayMayTinh.add(new MayTinh("Bình Phương 2 số", "Hằng Đẳng thức", R.drawable.h6));

    }
}