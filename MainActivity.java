package com.balde223.gla_project;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.TextWatcher;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends Activity {

    // Identifiants pour le passage de données

    String adr1 = null;
    String adr2 = null;
    String adr3 = null;
//    CheckBox preferences = null;
    String heure = null;
    String d = null;
/*    Button soumettre = null;

    CheckBox pref1 = null;
    CheckBox pref2 = null;
    CheckBox pref3 = null;
    CheckBox pref4 = null;
    CheckBox pref5 = null;
    CheckBox pref6 = null;
*/

    String recup_addr1 = "http://maps.googleapis.com/maps/api/geocode/json?address=546%20rue%20Baruch%20de%20Spinoza,%20Avignon&sensor=false\n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // On récupère toutes les vues dont on a besoin
/*
        final EditText adresse1 = (EditText)findViewById(R.id.adresse1);
        final EditText adresse2 = (EditText)findViewById(R.id.adresse2);
        final EditText adresse3 = (EditText)findViewById(R.id.adresse3);

        //    preferences = (CheckBox)findViewById(R.id.preferences);

        final EditText horaire = (EditText)findViewById(R.id.horaire);
        final EditText date = (EditText)findViewById(R.id.date);
        Button soumettre = (Button)findViewById(R.id.envoyer);


        final Button soumissionButton = (Button) findViewById(R.id.envoyer);
*/

  /*      soumissionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Display_results.class);
                intent.putExtra(adr1, adresse1.getText().toString());
                intent.putExtra(adr2, adresse2.getText().toString());
                intent.putExtra(adr3, adresse3.getText().toString());
                intent.putExtra(heure, horaire.getText().toString());
                intent.putExtra(d, date.getText().toString());
                startActivity(intent);
            }
        });
    */
    }
/*

    }

    private View.OnClickListener soumettreListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // Récupération de valeurs

            String adr1 = adresse1.getText().toString();
            String adr2 = adresse2.getText().toString();
            String adr3 = adresse3.getText().toString();

            String heure = horaire.getText().toString();

            String d = date.getText().toString();

            if(!pref1.isChecked() || !pref2.isChecked() || !pref3.isChecked() || !pref4.isChecked() || !pref5.isChecked() || !pref6.isChecked()) {
                Toast.makeText(MainActivity.this, "Veillez cocher au moins une préférence", Toast.LENGTH_SHORT).show();
            }

            else {
                pref1 = (CheckBox)findViewById(R.id.pref1);
                pref2 = (CheckBox)findViewById(R.id.pref2);
                pref3 = (CheckBox)findViewById(R.id.pref3);
                pref4 = (CheckBox)findViewById(R.id.pref4);
                pref5 = (CheckBox)findViewById(R.id.pref5);
                pref6 = (CheckBox)findViewById(R.id.pref6);

                HashMap<Integer, android.widget.CheckBox> hmap = new HashMap<Integer, android.widget.CheckBox>();
                hmap.put(1, pref1);
                hmap.put(2, pref2);
                hmap.put(3, pref3);
                hmap.put(4, pref4);
                hmap.put(5, pref5);
                hmap.put(6, pref6);
            }

        }
    };

*/
}