package com.example.managing_files;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothClass;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView majors;
    ArrayAdapter<String> adapter;
    ArrayList<String> majors_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        majors = findViewById(R.id.list);
        majors_list = new ArrayList<String>();
        InputStream inputStream = getApplicationContext().getResources().openRawResource(R.raw.majors);
        InputStreamReader inputreader = new InputStreamReader(inputStream);
        BufferedReader buffreader = new BufferedReader(inputreader);
        String line;
        StringBuilder text = new StringBuilder();
        adapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,majors_list);
        majors.setAdapter(adapter);
        try {
            while (( line = buffreader.readLine()) != null) {
                text.append(line);
                majors_list.add(line);
                adapter.notifyDataSetChanged();
            }
        }  catch (IOException e) {
            e.printStackTrace();
        }
        majors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),major.class);
                switch (position){
                    case 0:
                        intent.putExtra("major","cess");
                        startActivity(intent);
                        break;
                    case 1:
                        intent.putExtra("major","bldg");
                        startActivity(intent);
                        break;
                    case 2:
                        intent.putExtra("major","mcta");
                        startActivity(intent);
                        break;
                    case 3:
                        intent.putExtra("major","envr");
                        startActivity(intent);
                        break;
                    case 4:
                        intent.putExtra("major","ergy");
                        startActivity(intent);
                        break;
                    case 5:
                        intent.putExtra("major","comm");
                        startActivity(intent);
                        break;
                    case 6:
                        intent.putExtra("major","manf");
                        startActivity(intent);
                        break;
                    case 7:
                        intent.putExtra("major","laar");
                        startActivity(intent);
                        break;
                    case 8:
                        intent.putExtra("major","matl");
                        startActivity(intent);
                        break;
                    case 9:
                        intent.putExtra("major","cise");
                        startActivity(intent);
                        break;
                    case 10:
                        intent.putExtra("major","haud");
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public void logoPressed(View v){
        Intent intent = new Intent(getApplicationContext(),Discription.class);
        startActivity(intent);

    }
}
