package com.example.a10017404.sensordemo;

import android.content.Context;
import android.content.IntentSender;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView x, y, z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x = (TextView)findViewById(R.id.x_axis);
        y = (TextView)findViewById(R.id.y_axis);
        z = (TextView)findViewById(R.id.z_axis);
        SensorManager manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        Sensor mysensor = manager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        manager.registerListener(this,mysensor,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText(event.values[0]+"");
        y.setText(event.values[1]+"");
        z.setText(event.values[2]+"");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
