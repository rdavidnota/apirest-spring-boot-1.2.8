package bo.mibu.apptigo.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "usuario")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false)
    String fullname;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    Integer priority;
}
