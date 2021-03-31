package stock.reader.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;
import stock.reader.model.Stock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class Consumer {

    private final BlockingQueue<Stock> messages = new LinkedBlockingDeque<>();

    @Topic("stocks")
    public void receive(@MessageBody Stock stock) {
        messages.add(stock);
    }

    public BlockingQueue<Stock> getMessages() {
        return messages;
    }

}