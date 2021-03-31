package stock.reader.model;

import java.time.LocalDateTime;

public class GroupStock {

    private LocalDateTime time;
    private String code;
    private int high;
    private int low;

    public GroupStock() {
    }


    public GroupStock(LocalDateTime time, String code, int high, int low) {
        this.time = time;
        this.code = code;
        this.high = high;
        this.low = low;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    @Override
    public String toString() {
        return "GroupStock{" +
                "time=" + time +
                ", code='" + code + '\'' +
                ", high=" + high +
                ", low=" + low +
                '}';
    }
}
