package stock.reader.job;

import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import stock.reader.kafka.Consumer;
import stock.reader.model.GroupStock;
import stock.reader.model.Stock;
import stock.reader.utils.Calculate;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Singleton
public class WriteFileJob {

    private static final Logger LOG = LoggerFactory.getLogger(WriteFileJob.class);

    @Inject
    Consumer eventListener;

    @Scheduled(fixedDelay = "35s", initialDelay = "5s")
    void executeBroadcastMessage() {
        LOG.info("Simple Job every 25 seconds: {}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
        final BlockingQueue<Stock> messages = eventListener.getMessages();
        //break messages by minutes
        Map<Integer, List<Stock>> groupByTime = messages.stream()
                .sorted()
                .collect(Collectors.groupingBy(stock -> {
                      int hour = stock.getTime().getHour();
                      int minute = stock.getTime().getMinute();
                      return stock.getTime().withHour(hour).withMinute(minute).getMinute();
        }));

        //group by code
        groupByTime.forEach(
                (k, v) -> {
                    Map<String, List<Stock>> groupByCode = v.stream().collect(Collectors.groupingBy(Stock::getCode));
                    groupByCode.forEach(
                            (key, value) -> {
                                if (value.size() > 0){
                                    GroupStock groupStock = new GroupStock();
                                    int[] priceList = new int[value.size()];
                                    for (int i = 0; i < value.size(); i++) {
                                        priceList[i] = value.get(i).getPrice();
                                    }
                                    groupStock.setCode(key);
                                    groupStock.setTime(value.get(0).getTime());
                                    groupStock.setHigh(Calculate.getMaxValue(priceList));
                                    groupStock.setLow(Calculate.getMinValue(priceList));
                                    System.out.println(groupStock);
                                }
                            }
                    );

                }
        );


    }


}
