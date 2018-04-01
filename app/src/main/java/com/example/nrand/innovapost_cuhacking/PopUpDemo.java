package com.example.nrand.innovapost_cuhacking;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopUpDemo extends AppCompatActivity {
    Button closePopup, cmpButton;
    private PopupWindow pw;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        closePopup = findViewById(R.id.close_popup);
        closePopup.setText("Close");
        closePopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pw.dismiss();
            }
        });
        cmpButton = findViewById(R.id.cmpButton);
        pw = new PopupWindow(this);
    }

    public void showPopup(){

        // Inflate the popup_layout.xml
        //LinearLayout viewGroup = (LinearLayout) context.findViewById(R.id.popup);
        LayoutInflater layoutInflater = (LayoutInflater) PopUpDemo.this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = layoutInflater.inflate(R.layout.popup, (ViewGroup) findViewById(R.id.popup));
        pw = new PopupWindow(layout, 300, 370, true);
        pw.showAtLocation(layout, Gravity.CENTER, 0, 0);
    }
}
