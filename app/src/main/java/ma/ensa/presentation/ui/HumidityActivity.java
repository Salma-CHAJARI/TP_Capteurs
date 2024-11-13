package ma.ensa.presentation.ui;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import ma.ensa.presentation.R;

public class HumidityActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor humiditySensor;
    private TextView humidityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_humidity);

        humidityTextView = findViewById(R.id.humidityValue);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        humiditySensor = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

        if (humiditySensor == null) {
            humidityTextView.setText("Capteur d'humidité non disponible");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (humiditySensor != null) {
            sensorManager.registerListener(this, humiditySensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float humidity = event.values[0];
        humidityTextView.setText("Humidité : " + humidity + "%");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
