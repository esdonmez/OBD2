package com.example.seray.carstore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView oxygenGood;
    TextView oxygenNotBad;
    TextView oxygenBad;
    TextView carbondioxideGood;
    TextView carbondioxideNotBad;
    TextView carbondioxideBad;
    TextView engineSpeedGood;
    TextView engineSpeedNotBad;
    TextView engineSpeedBad;
    TextView speedTimingsGood;
    TextView speedTimingsNotBad;
    TextView speedTimingsBad;
    TextView engineTemperatureGood;
    TextView engineTemperatureNotBad;
    TextView engineTemperatureBad;
    TextView engineOilTemperatureGood;
    TextView engineOilTemperatureNotBad;
    TextView engineOilTemperatureBad;
    TextView fuelAmountGood;
    TextView fuelAmountNotBad;
    TextView fuelAmountBad;
    TextView count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        StartActivity.toast.cancel();
        oxygenGood = (TextView) findViewById(R.id.oxygenGood);
        oxygenNotBad = (TextView) findViewById(R.id.oxygenNotBad);
        oxygenBad = (TextView) findViewById(R.id.oxygenRisky);
        carbondioxideGood = (TextView) findViewById(R.id.carbondioxideGood);
        carbondioxideNotBad = (TextView) findViewById(R.id.carbondioxideNotBad);
        carbondioxideBad = (TextView) findViewById(R.id.carbondioxideRisky);
        engineSpeedGood = (TextView) findViewById(R.id.engineSpeedGood);
        engineSpeedNotBad = (TextView) findViewById(R.id.engineSpeedNotBad);
        engineSpeedBad = (TextView) findViewById(R.id.engineSpeedRisky);
        speedTimingsGood = (TextView) findViewById(R.id.speedGood);
        speedTimingsNotBad = (TextView) findViewById(R.id.speedNotBad);
        speedTimingsBad = (TextView) findViewById(R.id.speedRisky);
        engineTemperatureGood = (TextView) findViewById(R.id.engineGood);
        engineTemperatureNotBad = (TextView) findViewById(R.id.engineNotBad);
        engineTemperatureBad = (TextView) findViewById(R.id.engineRisky);
        engineOilTemperatureGood = (TextView) findViewById(R.id.oilGood);
        engineOilTemperatureNotBad = (TextView) findViewById(R.id.oilNotBad);
        engineOilTemperatureBad = (TextView) findViewById(R.id.oilRisky);
        fuelAmountGood = (TextView) findViewById(R.id.fuelGood);
        fuelAmountNotBad = (TextView) findViewById(R.id.fuelNotBad);
        fuelAmountBad = (TextView) findViewById(R.id.fuelRisky);
        count = (TextView) findViewById(R.id.count);

        count.setText(StartActivity.counter + "");
        carbondioxideGood.setText(CarbondioxideActivity.countGood + "");
        carbondioxideNotBad.setText(CarbondioxideActivity.countNotBad + "");
        carbondioxideBad.setText(CarbondioxideActivity.countBad + "");
        oxygenGood.setText(OxygenActivity.countGood + "");
        oxygenNotBad.setText(OxygenActivity.countNotBad + "");
        oxygenBad.setText(OxygenActivity.countBad + "");
        engineSpeedGood.setText(EngineSpeedActivity.countGood + "");
        engineSpeedNotBad.setText(EngineSpeedActivity.countNotBad + "");
        engineSpeedBad.setText(EngineSpeedActivity.countBad + "");
        speedTimingsGood.setText(StartActivity.countGood + "");
        speedTimingsNotBad.setText(StartActivity.countNotBad + "");
        speedTimingsBad.setText(StartActivity.countBad + "");
        engineTemperatureGood.setText(EngineTemperatureActivity.countGood + "");
        engineTemperatureNotBad.setText(EngineTemperatureActivity.countNotBad + "");
        engineTemperatureBad.setText(EngineTemperatureActivity.countBad + "");
        engineOilTemperatureGood.setText(EngineTemperatureActivity.countGood + "");
        engineOilTemperatureNotBad.setText(EngineTemperatureActivity.countNotBad + "");
        engineOilTemperatureBad.setText(EngineTemperatureActivity.countBad + "");
        fuelAmountGood.setText(FuelAmountActivity.countGood + "");
        fuelAmountNotBad.setText(FuelAmountActivity.countNotBad + "");
        fuelAmountBad.setText(FuelAmountActivity.countBad + "");
    }
}
