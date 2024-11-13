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
//import com.jjoe64.graphview.GraphView;
//import com.jjoe64.graphview.series.LineGraphSeries;
// com.jjoe64.graphview.series.DataPoint;

public class MagneticActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor magneticSensor;
    private TextView magneticTextView;
    //private GraphView magneticGraph;
   // private LineGraphSeries<DataPoint> series;
    //private double graphLastXValue = 0d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magnetic);

        magneticTextView = findViewById(R.id.magneticValue);
       // magneticGraph = findViewById(R.id.magneticGraph);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        magneticSensor = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        if (magneticSensor == null) {
            magneticTextView.setText("Capteur magnétique non disponible");
        } else {

            //series = new LineGraphSeries<>();
            //magneticGraph.addSeries(series);
            //magneticGraph.getViewport().setXAxisBoundsManual(true);
            //magneticGraph.getViewport().setMinX(0);
            //magneticGraph.getViewport().setMaxX(40);
            //magneticGraph.getViewport().setYAxisBoundsManual(true);
            //magneticGraph.getViewport().setMinY(0);
            //magneticGraph.getViewport().setMaxY(100);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (magneticSensor != null) {
            sensorManager.registerListener(this, magneticSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float magneticField = event.values[0];
        magneticTextView.setText("Champ magnétique : " + magneticField + " µT");

        //graphLastXValue += 1d;
        //series.appendData(new DataPoint(graphLastXValue, magneticField), true, 40); // Limiter à 40 points
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}
