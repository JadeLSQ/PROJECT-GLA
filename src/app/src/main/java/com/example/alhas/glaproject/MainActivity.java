package com.example.alhas.glaproject;

import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Message;
        import android.view.View;
        import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
        import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import java.io.UnsupportedEncodingException;


public class MainActivity extends Activity {
    Button addressButton;
    TextView addressTV;
    TextView latLongTV;
    EditText add1;
    EditText add2;
    EditText add3;
    CheckBox pref1;
    CheckBox pref2;
    CheckBox pref3;
    CheckBox pref4;
    CheckBox pref5;
    CheckBox pref6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        latLongTV = (TextView) findViewById(R.id.latLongTV);

        add1 = (EditText) findViewById(R.id.adresse1);
        add2 = (EditText) findViewById(R.id.adresse2);
        add3 = (EditText) findViewById(R.id.adresse3);

        pref1 = (CheckBox) findViewById(R.id.pref1);
        pref2 = (CheckBox) findViewById(R.id.pref2);
        pref3 = (CheckBox) findViewById(R.id.pref3);
        pref4 = (CheckBox) findViewById(R.id.pref4);
        pref5 = (CheckBox) findViewById(R.id.pref5);
        pref6 = (CheckBox) findViewById(R.id.pref6);

        addressButton = (Button) findViewById(R.id.envoyer);
        addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifie si au moins un des champs des adresses est utilisé
                sendRequest();

                String address1 = add1.getText().toString();
                String address2 = add2.getText().toString();
                String address3 = add3.getText().toString();

                Intent intent = new Intent(MainActivity.this, PlacesFinder.class);
                intent.putExtra("send1", address1);
                startActivity(intent);

                Intent intent2 = new Intent(MainActivity.this, PlacesFinder.class);
                intent2.putExtra("send2", address2);
                startActivity(intent2);

                Intent intent3 = new Intent(MainActivity.this, PlacesFinder.class);
                intent3.putExtra("send3", address3);

            }
        });
    }

    private void sendRequest() {
        String adresse1 = add1.getText().toString();
        String adresse2 = add2.getText().toString();
        String adresse3 = add3.getText().toString();
        if (adresse1.isEmpty() && adresse2.isEmpty() && adresse3.isEmpty()) {
            Toast.makeText(this, "Veillez saisir au moins une adresse!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            new DirectionFinder((DirectionFinderListener) this, adresse1, adresse2).execute();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}