package com.example.lei_siqi.gla_test;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    //declaration of button and TimePicker
    private TimePicker time_picker;
    private Button button_show_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showTime();
    }

    //Lorsque le bouton est cliqué, afficher le temps selectionné par TimePicker
    public void showTime(){
        //cast objects
        time_picker = (TimePicker)findViewById(R.id.timePicker);
        button_show_time = (Button)findViewById(R.id.Show_Time);

        //option: afficher l'heure a l'interieur de minute
        time_picker.setIs24HourView(true);

        //recuperer la date actuelle du systeme afin de mettre une contrainte
        Calendar c = Calendar.getInstance();
        final int hourSys, minuteSys;
        //hourSys = c.get(Calendar.HOUR_OF_DAY);
        //minuteSys = c.get(Calendar.MINUTE);

        //final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //final Date date = new Date();


        /**final int hourSaisie, minuteSaisie;
        if (Build.VERSION.SDK_INT >= 23 ){
            hourSaisie = time_picker.getHour();
            minuteSaisie = time_picker.getMinute();}
        else {
            hourSaisie = time_picker.getCurrentHour();
            minuteSaisie = time_picker.getCurrentMinute();}**/

        //onClick action
        button_show_time.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //if (time_picker.getHour() >= Calendar.HOUR_OF_DAY) {
                         //if (time_picker.getMinute() >= Calendar.MINUTE) {
                         //prendre un toast pour afficher le temps
                         //Toast.makeText(getBaseContext(), time_picker.getHour() + " : " + time_picker.getMinute(), Toast.LENGTH_SHORT).show();
                             Toast.makeText(getBaseContext(), time_picker.getHour()+ ":" + time_picker.getMinute(), Toast.LENGTH_SHORT).show();
                         //}

                        /**else {
                        Toast.makeText(getBaseContext(), "Veuillez saisir une date future", Toast.LENGTH_LONG).show();
                        }**/
                    }
                }
        );
    }
}
