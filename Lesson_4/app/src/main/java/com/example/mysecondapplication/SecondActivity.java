package com.example.mysecondapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int a = intent.getIntExtra("int1", -1);
        int b = intent.getIntExtra("int2", -2);

        Log.d("IntentValues","a:"+a+"b:"+b);
        intent.putExtra("Sum",a+b);
        setResult(this.RESULT_OK,intent);
    }
}