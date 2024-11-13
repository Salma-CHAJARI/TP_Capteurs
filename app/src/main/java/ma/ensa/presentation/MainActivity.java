package ma.ensa.presentation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ma.ensa.presentation.adapter.SensorAdapter;
import ma.ensa.presentation.bean.SensorInfo;

public class MainActivity extends AppCompatActivity {

    private RecyclerView sensorRecyclerView;
    private SensorManager sensorManager;
    private List<SensorInfo> sensorInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorRecyclerView = findViewById(R.id.sensorRecyclerView);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);


        sensorInfoList = new ArrayList<>();
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);

        for (Sensor sensor : sensorList) {
            SensorInfo sensorInfo = new SensorInfo(
                    sensor.getName(),
                    sensor.getVendor(),
                    sensor.getType(),
                    sensor.getVersion(),
                    sensor.getResolution(),
                    sensor.getPower(),
                    sensor.getMaximumRange(),
                    sensor.getMinDelay()
            );
            sensorInfoList.add(sensorInfo);
        }

        SensorAdapter adapter = new SensorAdapter(sensorInfoList, this);
        sensorRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        sensorRecyclerView.setAdapter(adapter);
    }
}
