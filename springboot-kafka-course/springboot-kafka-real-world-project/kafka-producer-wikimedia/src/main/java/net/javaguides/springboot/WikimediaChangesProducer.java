package net.javaguides.springboot;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class WikimediaChangesProducer {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {
        // to read real time stream data from wikimedia, we use event source
        // topic name = wikimedia_recentchange

        // This is EventHandler which will react to on Message which take MessageEvent
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topicName);
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";

        /*EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventSource = builder.build();*/

        // here EventSource (internally) usage Executer service to create the Threads.
        EventSource eventSource =new EventSource.Builder(eventHandler, URI.create(url)).build();

        eventSource.start();

       /* 1.
        eventSource.start() starts receiving events asynchronously.
        2.
        Main runner thread sleeps 10 minutes.
        3.
        After sleep ends, run() completes.
        4.
        Spring Boot app then shuts down (no code keeps it running indefinitely).*/

        TimeUnit.MINUTES.sleep(10);
    }
}
