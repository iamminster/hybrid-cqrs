package jp.co.hybrid.common.cqrs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfo {
    private String id;
    private String firstName;
    private String lastName;
}
