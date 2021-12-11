package com.course.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button imageButton4= (Button) findViewById(R.id.button);
        imageButton4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Product.class);
                startActivity(intent2);
            }

        });



        Button imageButton = (Button) findViewById(R.id.button2);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:010-7464-4324"));
                startActivity(intent);
            }
        });

        Button imageButton2 = (Button) findViewById(R.id.button5);
        imageButton2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), MapActivity.class);
                startActivity(intent2);
            }

        });

        Button imageButton3 = (Button) findViewById(R.id.button3);
        imageButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String[] TO = {"sangjoon97@naver.com"};
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "고객센터로 이메일보내기");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "고객센터로 이메일보냅니다.");
                try {
                    startActivity(Intent.createChooser(emailIntent, "고객센터 건의하기"));
                    finish();
                } catch (android.content.ActivityNotFoundException ex)
                {
                }
            }

        });
    }
}