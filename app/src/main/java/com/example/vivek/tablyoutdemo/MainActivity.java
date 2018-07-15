package com.example.vivek.tablyoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vivek.tablyoutdemo.adapter.BabyAdapter;
import com.example.vivek.tablyoutdemo.model.BabyName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    List<BabyName> babyNames = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        BabyAdapter adapter = new BabyAdapter(this, babyNames);
        readData();
        recyclerView.setAdapter(adapter);


    }

    private void readData() {
        InputStream is = getResources().openRawResource(R.raw.babynames);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";

        try {
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                Log.d("MyActivity", "Line: " + line);

                String[] tokens = line.split(",");

                BabyName name = new BabyName();
                name.setGender(tokens[1]);
                name.setMeaning(tokens[2]);
                name.setName(tokens[3]);
                name.setOrigin(tokens[4]);


                babyNames.add(name);
                Log.d(TAG, "Just created: " + name);

            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }
}


