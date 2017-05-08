package com.example.lei_siqi.gla_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

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
        //onClick action
        button_show_time.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //prendre un toast pour afficher le temps
                        Toast.makeText(getBaseContext(),
                                time_picker.getCurrentHour() + " : " + time_picker.getCurrentMinute(),
                                    Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
}
