package com.example.nrand.innovapost_cuhacking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        ArrayList<String> providers = extras.getStringArrayList("PROVIDERS");
        ArrayList<String> prices = extras.getStringArrayList("PRICES");
        ArrayList<String> services = extras.getStringArrayList("SERVICES");
        ArrayList<String> attrs = extras.getStringArrayList("ATTRIBUTES");
        //TextView textView = findViewById(R.id.text);
        //textView.setText(rateString);

        ArrayList<DataModel> items = new ArrayList<>();

        for(int i = 0; i < providers.size(); i++) {
            items.add(new DataModel(providers.get(i), prices.get(i), services.get(i), attrs.get(i)));
        }

        ListView listView = findViewById(R.id.list_view);
        CustomAdapter itemsAdapter = new CustomAdapter(this, items);
        listView.setAdapter(itemsAdapter);
    }
}