package ma.ensa.presentation.adapter;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ma.ensa.presentation.R;
import ma.ensa.presentation.bean.SensorInfo;
import ma.ensa.presentation.ui.AccelerometerActivity;
import ma.ensa.presentation.ui.HumidityActivity;
import ma.ensa.presentation.ui.LightActivity;
import ma.ensa.presentation.ui.MagneticActivity;
import ma.ensa.presentation.ui.PressureActivity;
import ma.ensa.presentation.ui.ProximityActivity;
import ma.ensa.presentation.ui.TemperatureActivity;

public class SensorAdapter extends RecyclerView.Adapter<SensorAdapter.SensorViewHolder> {

    private List<SensorInfo> sensorInfoList;
    private Context context;

    public SensorAdapter(List<SensorInfo> sensorInfoList, Context context) {
        this.sensorInfoList = sensorInfoList;
        this.context = context;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sensor_item, parent, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SensorViewHolder holder, int position) {
        SensorInfo sensorInfo = sensorInfoList.get(position);
        holder.sensorName.setText(sensorInfo.getName());

        holder.sensorDetails.setText(
                "ID: " + sensorInfo.getId() + "\n" +
                        "Vendor: " + sensorInfo.getVendor() + "\n" +
                        "Version: " + sensorInfo.getVersion() + "\n" +
                        "Type: " + sensorInfo.getType() + "\n" +
                        "Résolution: " + sensorInfo.getResolution() + "\n" +
                        "Consommation d'énergie: " + sensorInfo.getPower() + " mA\n" +
                        "Portée maximale: " + sensorInfo.getMaximumRange() + "\n" +
                        "Délai minimum: " + sensorInfo.getMinDelay() + " ms"
        );


        holder.itemView.setOnClickListener(view -> {
            Intent intent;
            switch (sensorInfo.getType()) {
                case Sensor.TYPE_ACCELEROMETER:
                    intent = new Intent(context, AccelerometerActivity.class);
                    break;
                case Sensor.TYPE_RELATIVE_HUMIDITY:
                    intent = new Intent(context, HumidityActivity.class);
                    break;
                case Sensor.TYPE_LIGHT:
                    intent = new Intent(context, LightActivity.class);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    intent = new Intent(context, ProximityActivity.class);
                    break;
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    intent = new Intent(context, TemperatureActivity.class);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    intent = new Intent(context, MagneticActivity.class);
                    break;
                case Sensor.TYPE_PRESSURE:
                    intent = new Intent(context, PressureActivity.class);
                    break;
                default:
                    return;
            }
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return sensorInfoList.size();
    }

    static class SensorViewHolder extends RecyclerView.ViewHolder {

        TextView sensorName;
        TextView sensorDetails;

        public SensorViewHolder(@NonNull View itemView) {
            super(itemView);
            sensorName = itemView.findViewById(R.id.sensorName);
            sensorDetails = itemView.findViewById(R.id.sensorDetails);
        }
    }
}
