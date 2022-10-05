package example04;

public class Watch {
    private final int DEFAULT_HOUR = 12;
    private int hour, minute, second;
    private static String brand;

    public Watch() {
    }

    public Watch(int hour, int minute, int second) {
        setHour(hour);
        setMinute(minute);
        this.second = second;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        }
        this.hour = DEFAULT_HOUR;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        }
    }

    public int getMinute() {
        return minute;
    }

    public String showInfo() {
        return "Brand: " + brand + ", Time: " + hour + ":" + minute + ":" + second;
    }

    public static String currentTime() {
        return "00:00:00";
    }

    public static String getBrand() {
        return brand;
    }

    public static void setBrand(String brand) {
        Watch.brand = brand;
    }
}
