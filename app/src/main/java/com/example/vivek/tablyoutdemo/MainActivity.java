package com.example.vivek.tablyoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.vivek.tablyoutdemo.adapter.BabyAdapter;
import com.example.vivek.tablyoutdemo.database.AppDatabase;
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
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database=AppDatabase.getDatabase(getApplicationContext());
        recyclerView = findViewById(R.id.recyclerview);
       readData();
        BabyAdapter adapter = new BabyAdapter(this, babyNames);
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
            String mGender,mMeaning,mName,mOrigin;
            while ((line = reader.readLine()) != null) {
                Log.d("MyActivity", "Line: " + line);

                String[] tokens = line.split(",");

                mGender=tokens[1];
                mMeaning=tokens[2];
                mName=tokens[3];
                mOrigin=tokens[4];


                BabyName babyName=new BabyName(mGender,mMeaning,mName,mOrigin);
                babyName.setGender(mGender);
                babyName.setName(mName);
                babyName.setOrigin(mOrigin);
                babyName.setMeaning(mMeaning);
                database.babyDao().insert(babyName);
                babyNames.add(babyName);
                Log.d(TAG, "Just created: " + mGender+mMeaning+mName+mOrigin);

            }
        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
    }
}


