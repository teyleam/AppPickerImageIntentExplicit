package com.example.apppickerimageintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TableLayout mTbLayout;
    int mColumn , mRow, mCount;
    String mRow1;
    String[] mArrDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTbLayout = findViewById(R.id.tableLayout);

        initView();
        // Get data
//        Intent intent = getIntent();
//        if(intent != null){
//            //Lấy dữ liệu text
//            //String text = intent.getStringExtra("text");
//            //Lấy dữ liệu mảng
//            String[] arrDrawable = intent.getStringArrayExtra("arr_drawable");
////            Animal animal = (Animal) intent.getSerializableExtra("animal");

      //  }
    }

    private void initView() {
        Intent intent = getIntent();
        if(intent != null) {
            String[] arrDrawable = intent.getStringArrayExtra("arr_drawable");
        }
//
//      mRow = (int) Math.ceil( Double.parseDouble((mArrDrawable.length / 3)+""));
       // mRow = (int) Math.ceil(Double.parseDouble((mArrDrawable.length / 3) + ""));
        mCount = 0;
        //mRow = 6;
        mColumn = 3;
        // 6 dong 3 cot
        for(int i = 0 ; i < mRow ; i++){
            //Create Row
            TableRow tableRow = new TableRow(this);

            for(int y = 0 ; y <mColumn ; y++){
               // if(mCount < mArrDrawable.length) {
                    ImageView imageView = new ImageView(this);
                    imageView.setImageResource(R.drawable.meolucky);
                    tableRow.addView(imageView);
                    mCount++;
               // }
            }
            mTbLayout.addView(tableRow);
        }

    }
}