package ma.ensa.presentation.bean;

public class SensorInfo {

    private static int idCounter = 1;
    private int id;
    private String name;
    private String vendor;
    private int type;
    private int version;
    private float resolution;
    private float power;
    private float maximumRange;
    private int minDelay;

    public SensorInfo(String name, String vendor, int type, int version, float resolution, float power, float maximumRange, int minDelay) {
        this.id = idCounter++;
        this.name = name;
        this.vendor = vendor;
        this.type = type;
        this.version = version;
        this.resolution = resolution;
        this.power = power;
        this.maximumRange = maximumRange;
        this.minDelay = minDelay;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getVendor() { return vendor; }
    public int getType() { return type; }
    public int getVersion() { return version; }
    public float getResolution() { return resolution; }
    public float getPower() { return power; }
    public float getMaximumRange() { return maximumRange; }
    public int getMinDelay() { return minDelay; }
}
