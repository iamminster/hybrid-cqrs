package jp.co.hybrid.common.cqrs.model.event;

import jp.co.hybrid.common.cqrs.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserUpdatedEvent implements Event {
    private UserInfo user;
}
