package com.example.nrand.innovapost_cuhacking;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.widget.Button;
import android.widget.Toast;

import com.shippo.Shippo;
import com.shippo.exception.ShippoException;
import com.shippo.model.Address;
import com.shippo.model.CarrierAccount;
import com.shippo.model.Parcel;
import com.shippo.model.Rate;
import com.shippo.model.Shipment;


public class MainActivity extends AppCompatActivity {
    Button compareButton;
    PopUpDemo popUpDemo;
    String rateString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        popUpDemo = new PopUpDemo();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Shippo.setApiKey("shippo_test_4b0042a819ba8765836420c5e16a3b004fd89c3e");


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


    public class GetInfoTask extends AsyncTask<Void, Void, Shipment> {
        Shipment shipment = null;
        @Override
        protected Shipment doInBackground(Void... voids) {
             try {
// To Address
                 HashMap<String, Object> addressToMap = new HashMap<String, Object>();
                 addressToMap.put("name", "Mr Hippo");
                 addressToMap.put("company", "Shippo");
                 addressToMap.put("street1", "215 Clayton St.");
                 addressToMap.put("city", "San Francisco");
                 addressToMap.put("state", "CA");
                 addressToMap.put("zip", "94117");
                 addressToMap.put("country", "US");
                 addressToMap.put("phone", "+1 555 341 9393");
                 addressToMap.put("email", "mrhippo@goshipppo.com");

// From Address
                 HashMap<String, Object> addressFromMap = new HashMap<String, Object>();
                 addressFromMap.put("name", "Ms Hippo");
                 addressFromMap.put("company", "San Diego Zoo");
                 addressFromMap.put("street1", "2920 Zoo Drive");
                 addressFromMap.put("city", "San Diego");
                 addressFromMap.put("state", "CA");
                 addressFromMap.put("zip", "92101");
                 addressFromMap.put("country", "US");
                 addressFromMap.put("email", "mshippo@goshipppo.com");
                 addressFromMap.put("phone", "+1 619 231 1515");

// Parcel
                 HashMap<String, Object> parcelMap = new HashMap<String, Object>();
                 parcelMap.put("length", "5");
                 parcelMap.put("width", "5");
                 parcelMap.put("height", "5");
                 parcelMap.put("distance_unit", "in");
                 parcelMap.put("weight", "2");
                 parcelMap.put("mass_unit", "lb");

                 HashMap<String, Object> accountMap = new HashMap<String, Object>();
                 accountMap.put("carrier", "fedex");
                 accountMap.put("account_id", "510087780");
                 accountMap.put("parameters", new HashMap<String, Object>() {
                     {
                         put("meter", "119026331");
                     }
                 });
                 accountMap.put("test", Boolean.TRUE);
                 accountMap.put("active", Boolean.TRUE);

                 //CarrierAccount fedex_account = CarrierAccount.create(accountMap);

                 accountMap = new HashMap<String, Object>();
                 accountMap.put("carrier", "fedex");
                 accountMap.put("account_id", "a15876b11c3d54dd");
                 accountMap.put("parameters", new HashMap<String, Object>() {
                     {
                         put("api_password", "160319f8007f8ed4db460f");
                         put("customer_number", "0008698670");
                     }
                 });
                 accountMap.put("test", Boolean.TRUE);
                 accountMap.put("active", Boolean.TRUE);

                 //CarrierAccount post_account = CarrierAccount.create(accountMap);

// Shipment
                 HashMap<String, Object> shipmentMap = new HashMap<String, Object>();
                 shipmentMap.put("address_to", addressToMap);
                 shipmentMap.put("address_from", addressFromMap);
                 shipmentMap.put("parcels", parcelMap);
                 //shipmentMap.put("carrier_accounts", new String[]{fedex_account.getObjectId(), post_account.getObjectId()});
                 shipmentMap.put("async", false);

                 shipment = Shipment.create(shipmentMap);
            }catch (ShippoException e) {
                e.printStackTrace();
            }
            return shipment;
        }

        @Override
        protected void onPostExecute(Shipment shipment) {

            StringBuilder rateStringBuilder = new StringBuilder();
            for(Rate r : shipment.getRates()) {
                rateStringBuilder.append(r.toString());
            }

            rateString = rateStringBuilder.toString();
        }
    }

    public void onClick(View v){
        if(v.getId() == R.id.cmpButton){
            //Toast.makeText(this, "Hello Work", Toast.LENGTH_LONG).show();
            //popUpDemo.showPopup();
            Intent i = new Intent(MainActivity.this, SecondActivity.class);
            i.putExtra("RATE", rateString);
            startActivity(i);
        }
    }
}
