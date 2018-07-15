package com.example.vivek.tablyoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vivek.tablyoutdemo.adapter.BabyAdapter;
import com.example.vivek.tablyoutdemo.model.BabyName;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    List<BabyName> babyNames = new ArrayList<>();
    private BabyAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        adapter=new BabyAdapter(this,babyNames);
        readData();
        recyclerView.setAdapter(adapter);


    }

    private void readData() {
        String json ="";
        try {
            InputStream is = getResources().openRawResource(R.raw.names);
            if (is != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(inputStreamReader);

                String line = "";
                StringBuilder sb = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                is.close();
                json = sb.toString();
            }
        } catch (IOException e) {

            e.printStackTrace();
        }

        Type listType = new TypeToken<List<BabyName>>() {}.getType();
        babyNames = new Gson().fromJson(json, listType);

//       for (int i=0;i<babyNames.size();i++){
//
//          String gender=babyNames.get(i).getGender();
//
//           Log.d(TAG, "Gender: "+gender);
//       }


    }


}

