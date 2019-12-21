package com.example.managing_files;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class major extends AppCompatActivity {

    ListView list;
    ArrayList<String> courses_list;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major);

        Intent intent = getIntent();
        courses_list = new ArrayList<>();
        adapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,courses_list);
        list = findViewById(R.id.list);
        list.setAdapter(adapter);
        String major = intent.getStringExtra("major");
        InputStream inputStream = null;
        if(major.equals("cess")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.cess_courses);
        }
        else if(major.equals("bldg")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.bldg_courses);
        }
        else if(major.equals("mcta")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.mcta_courses);
        }
        else if(major.equals("envr")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.envr_courses);
        }
        else if(major.equals("ergy")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.ergy_courses);
        }
        else if(major.equals("comm")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.comm_courses);
        }

        else if(major.equals("manf")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.manf_courses);
        }
        else if(major.equals("laar")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.laar_courses);
        }
        else if(major.equals("matl")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.matl_courses);
        }
        else if(major.equals("cise")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.cise_courses);
        }
        else if(major.equals("haud")){
            inputStream = getApplicationContext().getResources().openRawResource(R.raw.haud_courses);
        }
        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();
        try {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
                courses_list.add(line);
                adapter.notifyDataSetChanged();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }



    }
}
