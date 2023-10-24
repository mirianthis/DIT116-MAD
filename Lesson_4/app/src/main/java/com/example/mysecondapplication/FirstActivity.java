package com.example.mysecondapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class FirstActivity extends Activity {
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView textView = findViewById(R.id.textView);
        textView.setText(data.getIntExtra("sum", -1000));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.editText);
                String userText = editText.getText().toString();
                TextView textView = findViewById(R.id.textView);
                textView.setText(userText);
                Intent intent = new Intent();
//                intent.setAction(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.dit.hua.gr"));
                intent.setClass(getApplicationContext(),SecondActivity.class);
                intent.putExtra("int1",5);
                intent.putExtra("int2",9);
                startActivityForResult(intent,6);
            }
        });



        String[] strings = new String[]{"one","two","three","four"};
        ListView listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,strings);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FirstActivity.this,"value: "+parent.getItemAtPosition(position)+"position: "+position+"id:"+id,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
