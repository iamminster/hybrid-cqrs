package jp.co.hybrid.write.data.service.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWriteModel {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String creditCardNumber;
}
