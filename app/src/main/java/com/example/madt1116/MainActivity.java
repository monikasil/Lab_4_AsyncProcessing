package com.example.madt1116;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvCurrencyRates;
    private ArrayAdapter listAdapter;
    private ArrayList<String> currencyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lvCurrencyRates = findViewById(R.id.tvContent);
        this.currencyList = new ArrayList<String>();
        this.listAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, currencyList);
        this.lvCurrencyRates.setAdapter(this.listAdapter);
    }

    public void onBtnDownloadClick(View view) {

        currencyList.clear();
        currencyList.add("Loading...");
        listAdapter.notifyDataSetChanged();

        new DataLoader(){
            @Override
            public void onPostExecute(ArrayList<String> result)
            {
                currencyList.clear();
                currencyList.addAll(result);
                listAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}

