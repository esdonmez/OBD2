package com.example.seray.carstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class StartActivity extends AppCompatActivity {

    public static String fileData = "esd";
    public static int counter = 0;
    Timer timer = new Timer();
    public static Toast toast;
    TextView time;
    SpeedTimings speedTimings;
    CarbondioxideActivity carbondioxideActivity = new CarbondioxideActivity();
    OxygenActivity oxygenActivity = new OxygenActivity();
    FuelAmountActivity fuelAmountActivity = new FuelAmountActivity();
    EngineSpeedActivity engineSpeedActivity = new EngineSpeedActivity();
    EngineTemperatureActivity engineTemperatureActivity = new EngineTemperatureActivity();
    EngineOilTemperatureActivity engineOilTemperatureActivity = new EngineOilTemperatureActivity();

    private CustomGauge gauge1;
    private GoogleApiClient client;
    private TextView text1;

    public static int countBad;
    public static int countNotBad;
    public static int countGood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        toast = Toast.makeText(StartActivity.this, "", Toast.LENGTH_SHORT);
        countBad = 0;

        final Button oxygenButton = (Button) findViewById(R.id.oxygenButton);
        final Button carbonDioxideButton = (Button) findViewById(R.id.carbonDioxideButton);
        final Button engineSpeedButton = (Button) findViewById(R.id.engineSpeedButton);
        final Button fuelAmountButton = (Button) findViewById(R.id.fuelAmountButton);
        final Button gpsButton = (Button) findViewById(R.id.gpsButton);
        final Button engineTemperatureButton = (Button) findViewById(R.id.engineTemperatureButton);
        final Button engineOilTemperatureButton = (Button) findViewById(R.id.engineOilTemperatureButton);
        final Button controlButton = (Button) findViewById(R.id.controlButton);
        final Button stopButton = (Button) findViewById(R.id.stopButton);

        gauge1 = (CustomGauge) findViewById(R.id.gauge1);
        text1 = (TextView) findViewById(R.id.textView1);
        text1.setText(Integer.toString(gauge1.getValue()));

        time = (TextView) findViewById(R.id.time);

        StringBuffer sbuffer = new StringBuffer();
        InputStream is = this.getResources().openRawResource(R.raw.file);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(is));

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
                        try {
                            if(!fileData.isEmpty())
                            {
                                fileData = reader.readLine();
                                getData();
                                gauge1.setValue((int) MainActivity.vehicle.getSensor()[6].getValue());
                                text1.setText(Integer.toString(gauge1.getValue()) + MainActivity.vehicle.getSensor()[6].getUnit());
                                getStatus(MainActivity.vehicle.getSensor()[6].getValue());
                                oxygenButton.setText("Oxygen " + MainActivity.vehicle.getSensor()[0].getValue() + MainActivity.vehicle.getSensor()[0].getUnit());
                                oxygenActivity.getStatus(MainActivity.vehicle.getSensor()[0].getValue());
                                carbonDioxideButton.setText("Carbondioxide " + MainActivity.vehicle.getSensor()[1].getValue() + MainActivity.vehicle.getSensor()[1].getUnit());
                                carbondioxideActivity.getStatus(MainActivity.vehicle.getSensor()[1].getValue());
                                fuelAmountButton.setText("Fuel Amount " + MainActivity.vehicle.getSensor()[2].getValue() + MainActivity.vehicle.getSensor()[2].getUnit());
                                fuelAmountActivity.getStatus(MainActivity.vehicle.getSensor()[2].getValue());
                                engineSpeedButton.setText("Engine Speed " + MainActivity.vehicle.getSensor()[3].getValue() + MainActivity.vehicle.getSensor()[3].getUnit());
                                engineSpeedActivity.getStatus(MainActivity.vehicle.getSensor()[3].getValue());
                                engineTemperatureButton.setText("Engine Temperature " + MainActivity.vehicle.getSensor()[4].getValue() + MainActivity.vehicle.getSensor()[4].getUnit());
                                engineTemperatureActivity.getStatus(MainActivity.vehicle.getSensor()[4].getValue());
                                engineOilTemperatureButton.setText("Engine Oil Temperature " + MainActivity.vehicle.getSensor()[5].getValue() + MainActivity.vehicle.getSensor()[5].getUnit());
                                engineOilTemperatureActivity.getStatus(MainActivity.vehicle.getSensor()[5].getValue());
                                time.setText(Integer.toString((counter)));
                                counter++;
                            }
                            else
                            {
                                finish();
                                startActivity(new Intent(StartActivity.this, ResultActivity.class));
                            }


                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }, MainActivity.mode, MainActivity.mode);


        oxygenButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, OxygenActivity.class));
            }
        });

        carbonDioxideButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, CarbondioxideActivity.class));
            }
        });

        engineSpeedButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, EngineSpeedActivity.class));
            }
        });

        fuelAmountButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, FuelAmountActivity.class));
            }
        });

        gpsButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, GPS.class));
            }
        });

        engineTemperatureButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, EngineTemperatureActivity.class));
            }
        });

        engineOilTemperatureButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, EngineOilTemperatureActivity.class));
            }
        });

        controlButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                startActivity(new Intent(StartActivity.this, ControlActivity.class));
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                toast.cancel();
                finish();
                startActivity(new Intent(StartActivity.this, ResultActivity.class));
            }
        });
    }

    @Override
    public void onPause()
    {
        super.onPause();
    }

    public void getData()
    {
        String[] array = fileData.split(";");
        Sensor[] sensor = new Sensor[8];

        sensor[0] = new Exhaust(Double.valueOf(array[0])); // oxygen
        sensor[1] = new Exhaust(Double.valueOf(array[1])); // carbondioxide
        sensor[2] = new FuelAmount(Double.valueOf(array[2]));
        sensor[3] = new EngineSpeed(Double.valueOf(array[3]));
        sensor[4] = new Temperature(Double.valueOf(array[7])); // engine temperature
        sensor[5] = new Temperature(Double.valueOf(array[8])); // engine oil temperature
        sensor[6] = new SpeedTimings(Double.valueOf(array[4]));
        sensor[7] = new LocationCar(Double.valueOf(array[5]), Double.valueOf(array[6]));
        MainActivity.vehicle.setSensor(sensor);
    }

    private void getStatus(double amount)
    {
        double part = MainActivity.vehicle.maxSpeed / 3;

        if(part * 2 <= amount)
        {
            countBad++;
            toast.setText("RISKY. SLOW DOWN!");
            toast.show();
        }
        else if(part <= amount && amount < part * 2)
        {
            countNotBad++;
        }
        else
        {
            countGood++;
        }
    }
}
