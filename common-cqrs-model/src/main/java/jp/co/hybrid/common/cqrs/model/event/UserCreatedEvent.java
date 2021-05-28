package jp.co.hybrid.common.cqrs.model.event;

import jp.co.hybrid.common.cqrs.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserCreatedEvent implements Event {
    private UserInfo user;
}
