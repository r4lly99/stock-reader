package stock.reader.model;

import java.time.LocalDateTime;

public class Stock {

    private LocalDateTime time;
    private String code;
    private int price;

    public Stock() {
    }

    public Stock(LocalDateTime time, String code, int price) {
        this.time = time;
        this.code = code;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "time=" + time +
                ", code='" + code + '\'' +
                ", price=" + price +
                '}';
    }
}
