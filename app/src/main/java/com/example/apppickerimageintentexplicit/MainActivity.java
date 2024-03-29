package com.example.apppickerimageintentexplicit;

import static com.example.apppickerimageintentexplicit.R.id.imgPick;
import static com.example.apppickerimageintentexplicit.R.id.menu_item_refresh;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
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
                intent.putExtra("arr_drawable",mArrayDrawable);
//                Animal animal = new Animal("cat",2);
//                intent.putExtra("animal", animal);
                someActivityResultLauncher.launch(intent);
            }
        });
    }
    //Tra ve resource id Activity2
    private ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //There are no request codes
                        Intent data = result.getData();
                        int resourceData  = data.getIntExtra("resourceData", 1);
//                        Log.d("BBB",resourceData + "");
                        mImgPick.setImageResource(resourceData);
                        if (resourceData == mResourceRandom){
                            Toast.makeText(MainActivity.this, "Bạn chọn chính xác", Toast.LENGTH_SHORT).show();
                            mResourceRandom = randomImage(mArrayDrawable);
                            mImgRandom.setImageResource(mResourceRandom);
                            mImgPick.setImageResource(R.drawable.nophoto);
                        }else{
                            Toast.makeText(MainActivity.this, "Bạn chọn chưa chính xác", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Bạn chưa chọn hình", Toast.LENGTH_SHORT).show();
                    }
                }
            });


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