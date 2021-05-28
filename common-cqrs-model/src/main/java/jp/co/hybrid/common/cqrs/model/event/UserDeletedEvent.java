package jp.co.hybrid.common.cqrs.model.event;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDeletedEvent implements Event {
    private String userId;
}
