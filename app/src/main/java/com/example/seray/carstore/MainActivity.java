package com.example.seray.carstore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Vehicle vehicle = new Vehicle();

    public EditText et1;
    public EditText et2;
    public EditText et3;
    public RadioButton r1;
    public RadioButton r2;
    public static int mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.carModel);
        et2 = (EditText) findViewById(R.id.carType);
        et3 = (EditText) findViewById(R.id.carYear);
        r1 = (RadioButton) findViewById(R.id.radioNormal);
        r2 = (RadioButton) findViewById(R.id.radioFast);

        Button startButton = (Button)findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(et1.getText().toString().equals("") || et2.getText().toString().equals("") || et3.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill all spaces.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    createVehicle();
                    finish();
                    startActivity(new Intent(MainActivity.this, StartActivity.class));
                }
            }
        });
    }

    public void createVehicle()
    {
        vehicle.setType(et2.getText().toString());
        vehicle.setModel(et1.getText().toString());
        vehicle.setYear(et3.getText().toString());

        if(r1.isChecked() == true)
            mode = 1000;
        if(r2.isChecked() == true)
            mode = 300;
    }
}
