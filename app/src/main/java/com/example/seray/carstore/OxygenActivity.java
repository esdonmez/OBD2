package com.example.seray.carstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class OxygenActivity extends AppCompatActivity {

    Exhaust oxygen;
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
        setContentView(R.layout.activity_oxygen);
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

                        oxygen = (Exhaust) MainActivity.vehicle.getSensor()[0];

                        time.setText(Integer.toString(StartActivity.counter));
                        value.setText(oxygen.getValue() + " " + oxygen.getUnit());
                        status.setText(getStatus(oxygen.getValue()).toString());
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

        double part = MainActivity.vehicle.maxExhaust / 3;

        if(0 <= amount/100 && amount/100 < part)
        {
            countBad++;
            return "RISKY";
        }

        else if(part <= amount/100 && amount/100 <= 2 * part)
        {
            countNotBad++;
            return "NOT BAD";
        }

        else
        {
            countGood++;
            return "GOOD";
        }
    }

}
