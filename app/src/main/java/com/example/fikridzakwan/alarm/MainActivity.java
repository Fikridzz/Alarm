package com.example.fikridzakwan.alarm;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    TimePicker alarmTime;
    TextClock currentTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTime = findViewById(R.id.timePicker);
        currentTime = findViewById(R.id.textClock);
        final Ringtone ringtone = RingtoneManager.getRingtone(getApplicationContext(), RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if (currentTime.getText().toString().equals(AlarmTime())) {
                    ringtone.play();

                }else {
                    ringtone.stop();
                }

            }
        },0,1000);
    }

    public String AlarmTime() {

        Integer alarmHours = alarmTime.getCurrentHour();
        Integer alarmMinute = alarmTime.getCurrentMinute();
        String stringAlarmMinute;

        if (alarmMinute <  10) {
            stringAlarmMinute = "0";
            stringAlarmMinute = stringAlarmMinute.concat(alarmMinute.toString());
        } else {
            stringAlarmMinute = alarmMinute.toString();
        }

        String stringAlarmTime;


        if (alarmHours > 12) {
            alarmHours = alarmHours - 12;
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinute).concat(" PM");

        }else {
            stringAlarmTime = alarmHours.toString().concat(":").concat(stringAlarmMinute).concat(" AM");

        }

        return stringAlarmTime;

        }

}
