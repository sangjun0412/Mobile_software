package com.course.final_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Product extends AppCompatActivity {
    private CustomAdapter adapter;
    private ListView listView;
    private String[] titles;
    private ArrayList<CustomDTO> allList = new ArrayList<>();
    private ArrayList<CustomDTO> findList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);


        adapter = new CustomAdapter();
        listView = (ListView) findViewById(R.id.list);

        Button imageButton6 = (Button) findViewById(R.id.find_button);
        imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               EditText editText = findViewById(R.id.editText1);
               String editthing = editText.getText().toString();
               for(int i = 0 ; i<allList.size(); i++){
                   if(titles[i].contains(editthing)){
                       findList.add(allList.get(i));
                   }
               }
                adapter = new CustomAdapter();
                adapter.addArray(findList);
                listView.setAdapter(adapter);
                findList = new ArrayList<>();
            }
        });
        setData();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  imgRes = ((CustomDTO)adapter.getItem(position)).getResId();
                int doubleimage = ((CustomDTO)adapter.getItem(position)).getImage();
                String imgtitle = ((CustomDTO)adapter.getItem(position)).getTitle();
                String content =((CustomDTO)adapter.getItem(position)).getContent();
                Intent intent = new Intent(Product.this, NextProduct.class);
                intent.putExtra("doubleimage",doubleimage);
                intent.putExtra("imgRes", imgRes);
                intent.putExtra("imgtitle",imgtitle);
                intent.putExtra("content",content);
                startActivity(intent);
            }

        });
    }

    private void setData() {
        ArrayList<String> imageArr = new ArrayList<>();

        imageArr.add(getString(R.string.image1));
        imageArr.add(getString(R.string.image2));
        imageArr.add(getString(R.string.image3));
        imageArr.add(getString(R.string.image4));
        imageArr.add(getString(R.string.image5));
        imageArr.add(getString(R.string.image6));
        imageArr.add(getString(R.string.image7));
        imageArr.add(getString(R.string.image8));
        imageArr.add(getString(R.string.image9));
        imageArr.add(getString(R.string.image10));
        imageArr.add(getString(R.string.image11));
        ArrayList<Integer> image2Arr= new ArrayList<Integer>();
        image2Arr.add(R.drawable.bacon);
        image2Arr.add(R.drawable.egg);
        image2Arr.add(R.drawable.tuna);
        image2Arr.add(R.drawable.meatball);
        image2Arr.add(R.drawable.shrimp);
        image2Arr.add(R.drawable.steak);
        image2Arr.add(R.drawable.turkey);
        image2Arr.add(R.drawable.vege);
        image2Arr.add(R.drawable.mushroom);
        image2Arr.add(R.drawable.ham);
        image2Arr.add(R.drawable.special);

        titles = getResources().getStringArray(R.array.title);
        String[] contents = getResources().getStringArray(R.array.content);

        for (int i = 0; i < imageArr.size(); i++) {
            CustomDTO dto = new CustomDTO();
            dto.setResId(imageArr.get(i));
            dto.setTitle(titles[i]);
            dto.setContent(contents[i]);
            dto.setImage(image2Arr.get(i));
            allList.add(dto);
            adapter.addItem(dto);
        }
    }
}