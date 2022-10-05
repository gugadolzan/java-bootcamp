package example02;

public class Watch {
    private int hour, minute, second;

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
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        }
    }

    public int getMinute() {
        return minute;
    }

    public void showTime() {
        System.out.println("Current time: " + hour + ":" + minute + ":" + second);
    }
}
