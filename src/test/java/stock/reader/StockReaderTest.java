package stock.reader;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import stock.reader.kafka.Consumer;
import stock.reader.model.Stock;

import javax.inject.Inject;
import java.util.concurrent.TimeUnit;

@MicronautTest(environments = "kafka")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StockReaderTest {

    @Inject
    Consumer consumer;

    @Test
    void testReadBroadcastEvent() throws InterruptedException {
        Stock transferEvent = consumer.getMessages().poll(5, TimeUnit.SECONDS);
        Assertions.assertNotNull(transferEvent);
    }

}
