package stock.reader.kafka;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.OffsetReset;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.MessageBody;
import stock.reader.model.Stock;

@KafkaListener(offsetReset = OffsetReset.EARLIEST)
public class Consumer {

    @Topic("stocks")
    public void receive(@MessageBody Stock stock) {
        System.out.println("Got Stock - " + stock);
    }

}