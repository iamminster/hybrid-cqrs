package jp.co.hybrid.write.data.service.backend.messaging;

import jp.co.hybrid.common.cqrs.model.event.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class EventProducer {

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;


    @Value(value = "${kafka.topic.name}")
    private String topicName;

    public void notify(Event event) {

        ListenableFuture<SendResult<String, Event>> future = kafkaTemplate.send(topicName, event);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Event>>() {

            @Override
            public void onSuccess(SendResult<String, Event> result) {
                System.out.println("Sent message=[" + event + "] with offset=[" + result.getRecordMetadata()
                        .offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + event + "] due to : " + ex.getMessage());
            }
        });
    }
}
