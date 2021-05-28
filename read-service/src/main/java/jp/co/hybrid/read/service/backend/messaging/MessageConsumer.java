package jp.co.hybrid.read.service.backend.messaging;

import jp.co.hybrid.common.cqrs.model.UserInfo;
import jp.co.hybrid.common.cqrs.model.event.Event;
import jp.co.hybrid.common.cqrs.model.event.UserCreatedEvent;
import jp.co.hybrid.common.cqrs.model.event.UserDeletedEvent;
import jp.co.hybrid.common.cqrs.model.event.UserUpdatedEvent;
import jp.co.hybrid.read.service.backend.ReadRepository;
import jp.co.hybrid.read.service.backend.UserReadModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @Autowired
    private ReadRepository readRepository;

    @KafkaListener(topics = "${kafka.topic.name}", groupId = "cqrs", containerFactory = "cqrsKafkaListenerContainerFactory")
    public void listenGroupFoo(Event event) {
        System.out.println("Received Message in group 'cqrs': " + event.toString());
        if (event instanceof UserCreatedEvent) {
            UserInfo info = ((UserCreatedEvent)event).getUser();
            UserReadModel user = new UserReadModel(info.getId(), info.getFirstName(), info.getLastName());
            readRepository.save(user);
        } else if (event instanceof UserUpdatedEvent) {
            UserInfo info = ((UserCreatedEvent)event).getUser();
            UserReadModel user = new UserReadModel(info.getId(), info.getFirstName(), info.getLastName());
            readRepository.save(user);
        } else if (event instanceof UserDeletedEvent) {
            readRepository.deleteById(((UserDeletedEvent)event).getUserId());
        }
    }
}
