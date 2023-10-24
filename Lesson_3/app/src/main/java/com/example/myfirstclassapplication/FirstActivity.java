package com.example.myfirstclassapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        Button button = findViewById(R.id.mybutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView = findViewById(R.id.mytext);
                String text = textView.getText().toString();
                Log.i("INFO", text);
                Toast.makeText(FirstActivity.this,text,Toast.LENGTH_SHORT).show();
                textView.setText("Blah blah");
            }


        });

    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("INFO","Stopping");
    }
}
