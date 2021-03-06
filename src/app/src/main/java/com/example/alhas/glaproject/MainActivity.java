package com.example.alhas.glaproject;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;


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

    Button bot1;
    int heur_x;
    int minute_x;
    static final int Date_DIALOG_ID = 0;
    Button bot;
    int year_x, month_x, day_x;
    static final int Hour_DIALOG_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bot =(Button)findViewById(R.id.btn);
        bot1 = (Button) findViewById(R.id.btn1);

        bot1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showDialog(Hour_DIALOG_ID);
            }
        });

        bot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(Date_DIALOG_ID);
            }
        });

        final Calendar cal = Calendar.getInstance();
        this.heur_x = cal.get(Calendar.HOUR);
        this.minute_x = cal.get(Calendar.MINUTE);
        this.year_x = cal.get(Calendar.YEAR);
        this.month_x = cal.get(Calendar.MONTH);
        this.day_x = cal.get(Calendar.DAY_OF_MONTH);

        AfficheDialogOnClick1();
        AfficheDialogOnClick();

        add1 = (EditText) findViewById(R.id.adresse1);
        add2 = (EditText) findViewById(R.id.adresse2);
        add3 = (EditText) findViewById(R.id.adresse3);

        pref1 = (CheckBox) findViewById(R.id.pref1);
        pref2 = (CheckBox) findViewById(R.id.pref2);
        pref3 = (CheckBox) findViewById(R.id.pref3);
        pref4 = (CheckBox) findViewById(R.id.pref4);
        pref5 = (CheckBox) findViewById(R.id.pref5);
        pref6 = (CheckBox) findViewById(R.id.pref6);

        latLongTV = (TextView) findViewById(R.id.latLongTV);

        addressButton = (Button) findViewById(R.id.envoyer);
        addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Vérifie si au moins un des champs des adresses est utilisé
               // sendRequest();

                String address1 = add1.getText().toString();
                String address2 = add2.getText().toString();
                String address3 = add3.getText().toString();

                Intent intent = new Intent(MainActivity.this, PlacesFinder.class);
                intent.putExtra("send1", address1);
                intent.putExtra("send2", address2);
                intent.putExtra("send3", address3);
                startActivity(intent);

            }
        });
    }

    public void AfficheDialogOnClick1() {


        bot1 = (Button) findViewById(R.id.btn1);
        bot1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(Hour_DIALOG_ID);
                    }
                }
        );
    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case Date_DIALOG_ID:
                return new DatePickerDialog(this,
                        Calendrier,
                        year_x, month_x, day_x);

            case Hour_DIALOG_ID:
                return new TimePickerDialog(this,
                        Time, heur_x, minute_x, true);

        }
        return null;
    }

    private TimePickerDialog.OnTimeSetListener Time = new TimePickerDialog.OnTimeSetListener() {


        @Override
        public void onTimeSet(TimePicker view, int heur, int minute) {

            heur_x = heur;
            minute_x = minute;

            if (heur > Calendar.getInstance().get(Calendar.HOUR)) {
                Toast.makeText(MainActivity.this, heur_x + ":" + minute_x, Toast.LENGTH_SHORT).show();
            } else if (heur < Calendar.getInstance().get(Calendar.HOUR))
            {
                Toast.makeText(MainActivity.this, "Merci de Choisir une heure ultérieure s'il vous plaît", Toast.LENGTH_LONG).show();
            }
            else if ( heur == Calendar.getInstance().get(Calendar.HOUR) && minute >= Calendar.getInstance().get(Calendar.MINUTE)){

                Toast.makeText(MainActivity.this, heur_x + ":" + minute_x, Toast.LENGTH_LONG).show();
            }

            else if ( heur == Calendar.getInstance().get(Calendar.HOUR) && minute < Calendar.getInstance().get(Calendar.MINUTE)){

                Toast.makeText(MainActivity.this, "Merci de Choisir une heure ultérieure s'il vous plaît", Toast.LENGTH_SHORT).show();
            }
        }
    };

    public void AfficheDialogOnClick() {

        bot = (Button) findViewById(R.id.btn);
        bot.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showDialog(Date_DIALOG_ID);
                    }
                }

        );
    }

    private DatePickerDialog.OnDateSetListener Calendrier = new DatePickerDialog.OnDateSetListener() {


        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

            year_x = year;
            month_x = month + 1;
            day_x = dayOfMonth;
            if (year >= Calendar.getInstance().get(Calendar.YEAR) && month >= Calendar.getInstance().get(Calendar.MONTH) &&
                    dayOfMonth >= Calendar.getInstance().get(Calendar.DAY_OF_MONTH))
                Toast.makeText(MainActivity.this, day_x + "/" + month_x + "/" + year_x, Toast.LENGTH_LONG).show();
            else {

                Toast.makeText(MainActivity.this, "Merci de Choisir une date ultérieure s'il vous plaît  ", Toast.LENGTH_LONG).show();
            }
        }
    };

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