package com.example.apppickerimageintentexplicit;

import static com.example.apppickerimageintentexplicit.R.id.imgPick;
import static com.example.apppickerimageintentexplicit.R.id.menu_item_refresh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
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
        mImgPick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                // Truyền chuỗi sang màn hình 2
                //intent.putExtra("text","Hello");
                //Truyền mảng array (1 mảng )
//                intent.putExtra("arr_drawable",mArrayDrawable);
                Animal animal = new Animal("cat",2);
                intent.putExtra("animal", animal);
                startActivity(intent);
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
            if(id == R.id.menu_item_refresh){
                mResourceRandom = randomImage(mArrayDrawable);
                mImgRandom.setImageResource(randomImage(mArrayDrawable));
        }
        return true;
    }
}