package com.example.apppickerimageintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get data

        Intent intent = getIntent();
        if(intent != null){
            //Lấy dữ liệu text
            //String text = intent.getStringExtra("text");
            //Lấy dữ liệu mảng
            String[] arrDrawable = intent.getStringArrayExtra("arr_drawable");
            Toast.makeText(MainActivity2.this,arrDrawable.length + "",Toast.LENGTH_SHORT).show();
        }
    }
}