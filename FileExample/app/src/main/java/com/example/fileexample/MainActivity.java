package com.example.fileexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Main Activity:onPause","onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Main Activity:onDestroy","onDestroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Main Activity:onStop","onStop");
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();
        try {
           FileOutputStream stream = openFileOutput("text.txt",this.MODE_PRIVATE);
            OutputStreamWriter writer = new OutputStreamWriter(stream);
            writer.write(text);
            writer.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("Main Activity:onResume","onResume");
        try {
            FileInputStream stream = openFileInput("test.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String text = reader.readLine();
            TextView textView = findViewById(R.id.textView);
            textView.setText(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}