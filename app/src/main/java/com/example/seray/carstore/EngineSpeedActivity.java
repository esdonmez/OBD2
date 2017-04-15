package com.example.seray.carstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class EngineSpeedActivity extends AppCompatActivity {

    EngineSpeed engineSpeedTime;
    Timer timer = new Timer();
    TextView time;
    TextView value;
    TextView status;

    public static int countGood;
    public static int countNotBad;
    public static int countBad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engine_speed);
        time = (TextView) findViewById(R.id.time);
        value = (TextView) findViewById(R.id.value);
        status = (TextView) findViewById(R.id.status);

        countBad = 0;
        countGood = 0;
        countNotBad = 0;

        timer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run()
            {
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        engineSpeedTime = (EngineSpeed) MainActivity.vehicle.getSensor()[3];

                        time.setText(Integer.toString(StartActivity.counter));
                        value.setText(engineSpeedTime.getValue() + " " + engineSpeedTime.getUnit());
                        status.setText(getStatus(engineSpeedTime.getValue()).toString());
                    }
                });
            }
        }, MainActivity.mode, MainActivity.mode);

    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    public String getStatus(double amount)
    {

        double part = MainActivity.vehicle.maxEngineSpeed / 3;

        if(0 <= amount && amount < part)
        {
            countGood++;
            return "GOOD";
        }

        else if(part <= amount && amount <= 2 * part)
        {
            countNotBad++;
            return "NOT BAD";
        }

        else
        {
            countBad++;
            return "SPEED LEVEL IS RISKY";
        }
    }
}
