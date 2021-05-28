package jp.co.hybrid.write.data.service.backend;

import jp.co.hybrid.common.cqrs.model.UserInfo;
import jp.co.hybrid.common.cqrs.model.event.Event;
import jp.co.hybrid.common.cqrs.model.event.UserCreatedEvent;
import jp.co.hybrid.common.cqrs.model.event.UserDeletedEvent;
import jp.co.hybrid.common.cqrs.model.event.UserUpdatedEvent;
import jp.co.hybrid.write.data.service.backend.messaging.EventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WriteService {
    @Autowired
    private WriteRepository writeRepository;

    @Autowired
    private EventProducer producer;

    private void notifyUserCreated(Event event) {
        producer.notify(event);
    }

    private void notifyUserUpdated(Event event) {
        producer.notify(event);
    }

    private void notifyUserDeleted(Event event) {
        producer.notify(event);
    }

    public String createUser(UserWriteModel user) {
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        writeRepository.save(user);
        UserCreatedEvent event = new UserCreatedEvent(new UserInfo(user.getId(), user.getFirstName(), user.getLastName()));
        notifyUserCreated(event);
        return userId;
    }

    public String updateUser(String userId, UserWriteModel user) {
        user.setId(userId);
        writeRepository.save(user);
        UserUpdatedEvent event = new UserUpdatedEvent(new UserInfo(user.getId(), user.getFirstName(), user.getLastName()));
        notifyUserUpdated(event);
        return userId;
    }

    public String deleteUser(String userId) {
        writeRepository.deleteById(userId);
        UserDeletedEvent event = new UserDeletedEvent(userId);
        notifyUserDeleted(event);
        return userId;
    }
}
