package com.example.apppickerimageintentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String[] mArrayDrawable;
    private ImageView mImgPick,mImgRandom;
    private int mResourceRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mArrayDrawable = getResources().getStringArray(R.array.ArrayDrawable);

        init();
        event();

    }

    private void event() {
    }

    private void init() {
        // Anh xa
        mImgPick = findViewById(R.id.imgPick);
        mImgRandom = findViewById(R.id.imgRandom);

        //Tạo mảng chứa tên hình
        mArrayDrawable = getResources().getStringArray(R.array.ArrayDrawable);

        //Xử lý việc gán hình cho hình random
        mResourceRandom = randomImage(mArrayDrawable);
        mImgRandom.setImageResource(randomImage(mArrayDrawable));
    }
    private int randomImage(String[] arrDrawable){
        int index = new Random().nextInt(arrDrawable.length);
        String name = arrDrawable[index];
        //Truyền vị trí hình theo [] resource drawable
        int resourceImage = getResources().getIdentifier(name,"drawable",getPackageName());
        return resourceImage;
    }
}