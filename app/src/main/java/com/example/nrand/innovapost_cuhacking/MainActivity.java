package com.example.nrand.innovapost_cuhacking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nrand.innovapost_cuhacking.easyPost.EasyPost;
import com.example.nrand.innovapost_cuhacking.easyPost.exception.EasyPostException;
import com.example.nrand.innovapost_cuhacking.easyPost.model.Address;
import com.example.nrand.innovapost_cuhacking.easyPost.model.Parcel;
import com.example.nrand.innovapost_cuhacking.easyPost.model.Rate;
import com.example.nrand.innovapost_cuhacking.easyPost.model.Shipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    Button compareButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        EasyPost.apiKey = "HS3r6jpKadfRo487ngMB2g";


        GetInfoTask getInfoTask = new GetInfoTask();
        getInfoTask.execute();

        compareButton=findViewById(R.id.cmpButton);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public class GetInfoTask extends AsyncTask<Void, Void, List<Shipment>> {

        @Override
        protected List<Shipment> doInBackground(Void... voids) {
            Map<String, Object> fromAddressMap = new HashMap<>();
            fromAddressMap.put("name", "Simpler Postage Inc");
            fromAddressMap.put("street1", "388 Townsend St");
            fromAddressMap.put("street2", "");
            fromAddressMap.put("city", "San Francisco");
            fromAddressMap.put("state", "CA");
            fromAddressMap.put("zip", "94107");

            Map<String, Object> toAddressMap = new HashMap<>();
            //toAddressMap.put("name", "Sawyer Bateman");
            toAddressMap.put("street1", "202 Colonial Dr");
            toAddressMap.put("street2", "");
            toAddressMap.put("city", "Horseheads");
            toAddressMap.put("state", "NY");
            toAddressMap.put("zip", "14845");

            Map<String, Object> parcelMap = new HashMap<>();
            parcelMap.put("weight", 22.9);
            parcelMap.put("height", 12.1);
            parcelMap.put("width", 8);
            parcelMap.put("length", 19.8);
            Shipment shipment1 = null;
            Shipment shipment2 = null;
             try {
                Address fromAddress = Address.create(fromAddressMap);
                Address toAddress = Address.create(toAddressMap);
                Parcel parcel = Parcel.create(parcelMap);

                Address verified = toAddress.verify();

                Map<String, Object> shipmentMap = new HashMap<>();
                shipmentMap.put("to_address", toAddress);
                shipmentMap.put("from_address", fromAddress);
                shipmentMap.put("parcel", parcel);

                shipment1 = Shipment.create(shipmentMap);

                shipment2 = Shipment.create(shipmentMap);

                // buy postage
                List<String> buyCarriers = new ArrayList<String>();
                buyCarriers.add("USPS");
                List<String> buyServices = new ArrayList<String>();

                shipment1 = shipment1.buy(shipment1.lowestRate(buyCarriers, buyServices));



            }catch (EasyPostException e) {
                e.printStackTrace();
            }

            List<Shipment> shipments = new ArrayList<>();
             shipments.add(shipment1);
            return shipments;
        }

        @Override
        protected void onPostExecute(List<Shipment> shipments) {
            TextView helloWorld = findViewById(R.id.hello);
            ArrayList<Rate> rates = new ArrayList<>();
            rates.addAll(shipments.get(0).getRates());
            StringBuilder rateStringBuilder = new StringBuilder();
            for(Rate r : rates) {
                rateStringBuilder.append(r.getRate() + "\n");
            }
            String rateString = rateStringBuilder.toString();
            helloWorld.setText(rateString);
        }
    }

    public void onClick(View v){
        if(v.getId() == R.id.cmpButton){
            Toast.makeText(this, "Hello Work", Toast.LENGTH_LONG).show();
        }
    }


}
