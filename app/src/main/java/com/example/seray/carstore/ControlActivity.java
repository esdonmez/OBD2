package com.example.seray.carstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ControlActivity extends AppCompatActivity {

    Control control = new Control();
    Timer timer = new Timer();
    TextView time;
    TextView valueSpeed;
    TextView valueFuel;
    TextView valueCarbondioxide;
    TextView status;
    TextView status2;
    TextView valueEngineSpeed;
    TextView valueEngineTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        time = (TextView) findViewById(R.id.time);
        valueSpeed = (TextView) findViewById(R.id.valueSpeed);
        valueFuel = (TextView) findViewById(R.id.valueFuel);
        valueCarbondioxide = (TextView) findViewById(R.id.valueCarbondioxide);
        status = (TextView) findViewById(R.id.status);
        valueEngineSpeed = (TextView) findViewById(R.id.valueEngineSpeed);
        valueEngineTemperature = (TextView) findViewById(R.id.valueEngineTemperature);
        status2 = (TextView) findViewById(R.id.status2);

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

                        Control.sensor1 = MainActivity.vehicle.getSensor()[6]; // Speed
                        Control.sensor2 = MainActivity.vehicle.getSensor()[2]; // Fuel Amount
                        Control.sensor3 = MainActivity.vehicle.getSensor()[1]; // Carbondioxide

                        time.setText(Integer.toString(StartActivity.counter));
                        valueSpeed.setText(Control.sensor1.getValue() + " " + Control.sensor1.getUnit());
                        valueFuel.setText(Control.sensor2.getValue() + " " + Control.sensor2.getUnit());
                        valueCarbondioxide.setText(Control.sensor3.getValue() + " " + Control.sensor3.getUnit());
                        status.setText(Notification1().toString());

                        Control.sensor2 = MainActivity.vehicle.getSensor()[3]; // Engine Speed
                        Control.sensor3 = MainActivity.vehicle.getSensor()[4]; // Engine Temperature

                        time.setText(Integer.toString(StartActivity.counter));
                        valueEngineSpeed.setText(Control.sensor2.getValue() + " " + Control.sensor2.getUnit());
                        valueEngineTemperature.setText(Control.sensor3.getValue() + " " + Control.sensor3.getUnit());
                        status2.setText(Notification2().toString());
                    }
                });
            }
        }, MainActivity.mode, MainActivity.mode);
    }

    public String Notification1()
    {
        double part = MainActivity.vehicle.maxSpeed / 3;

        if(0 <= Control.sensor1.getValue() && Control.sensor1.getValue() < part) // Speed
        {
            return "GOOD";
        }
        else if(part <= (Control.sensor1.getValue()) && (Control.sensor1.getValue()) <= 2 * part)
        {
            return "NOT BAD";
        }
        else
        {
            part = MainActivity.vehicle.maxFuelAmount / 3;

            if(0 <= Control.sensor2.getValue() && Control.sensor2.getValue() < part) // Fuel Consumption
            {
                return "GOOD";
            }

            else if(part <= Control.sensor2.getValue() && Control.sensor2.getValue() <= 2 * part)
            {
                return "NOT BAD";
            }

            else
            {
                part = MainActivity.vehicle.maxExhaust / 3;

                if(0 <= ((12*Control.sensor3.getValue())/100) && ((12*Control.sensor3.getValue())/100) < part) // Carbondioxide Emission
                {
                    return "GOOD";
                }

                else if(part <= ((12*Control.sensor3.getValue())/100) && ((12*Control.sensor3.getValue())/100) <= 2 * part)
                {
                    return "HIGH FUEL CONSUMPTION. NORMAL\n CARBONDIOXIDE DATA.";
                }

                else
                {
                    return "HIGH FUEL CONSUMPTION. CAUSES\n HIGH CARBONDIOXIDE.";
                }
            }
        }
    }

    public String Notification2()
    {
        double part = MainActivity.vehicle.maxSpeed / 3;

        if(0 <= Control.sensor1.getValue() && Control.sensor1.getValue() < part) // Speed
        {
            return "GOOD";
        }
        else if(part <= (Control.sensor1.getValue()) && (Control.sensor1.getValue()) <= 2 * part)
        {
            return "NOT BAD";
        }
        else
        {
            part = MainActivity.vehicle.maxEngineSpeed / 3;

            if(0 <= Control.sensor2.getValue() && Control.sensor2.getValue() < part) // Engine Speed
            {
                return "GOOD";
            }

            else if(part <= Control.sensor2.getValue() && Control.sensor2.getValue() <= 2 * part)
            {
                return "NOT BAD";
            }

            else
            {
                part = MainActivity.vehicle.maxEngineTemperature / 3;

                if(0 <= Control.sensor3.getValue() && Control.sensor3.getValue() < part) // Engine Temperature
                {
                    return "GOOD";
                }

                else if(part <= ((12*Control.sensor3.getValue())/100) && ((12*Control.sensor3.getValue())/100) <= 2 * part)
                {
                    return "HIGH ENGINE SPEED. NORMAL\n ENGINE TEMPERATURE.";
                }

                else
                {
                    return "HIGH ENGINE SPEED CAUSES HIGH\n ENGINE TEMPERATURE.\n SLOW DOWN.";
                }
            }
        }
    }
}
