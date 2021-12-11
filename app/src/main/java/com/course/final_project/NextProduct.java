package com.course.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NextProduct extends AppCompatActivity {

    private Intent intent;
    private ImageView imageView;
    String text_title;
    String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_product);

        intent  = getIntent();
        imageView = (ImageView) findViewById(R.id.imageView);
        text_title = intent.getStringExtra("imgtitle");
        content =intent.getStringExtra("content");
        imageView.setImageResource(intent.getIntExtra("doubleimage", 0));
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(text_title);
        TextView textView2 = (TextView)findViewById(R.id.textView3);
        textView2.setText(content);

    }

}