package com.example.nrand.innovapost_cuhacking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        String rateString = extras.getString("RATE");
        TextView textView = findViewById(R.id.rateTextView);
        textView.setText(rateString);
    }
}
