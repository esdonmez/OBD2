package com.example.seray.carstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class EngineOilTemperatureActivity extends AppCompatActivity {

    Temperature engineOilTemperature;
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
        setContentView(R.layout.activity_engine_oil_temperature);
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

                        engineOilTemperature = (Temperature) MainActivity.vehicle.getSensor()[5];

                        time.setText(Integer.toString(StartActivity.counter));
                        value.setText(engineOilTemperature.getValue() + " " + engineOilTemperature.getUnit());
                        status.setText(getStatus(engineOilTemperature.getValue()));
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

        double part = MainActivity.vehicle.maxEngineOilTemperature / 3;

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
            return "RISKY TEMPERATURE";
        }
    }
}
