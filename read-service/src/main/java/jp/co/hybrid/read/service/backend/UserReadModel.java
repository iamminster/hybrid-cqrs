package jp.co.hybrid.read.service.backend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReadModel {
    @Id
    private String id;
    private String firstName;
    private String lastName;

}
