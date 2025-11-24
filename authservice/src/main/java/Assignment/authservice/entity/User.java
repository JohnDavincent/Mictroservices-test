package Assignment.authservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // make Id auto increment
    private Long id;
    @Column(unique = true, nullable = false) // username must unique and cannot be null
    private String username;

    @Column(nullable = false) // all of the column cannot be null
    private String password;
    private String email;
    private String phone;
    private String name;
    private Integer age;
    private String Location;


}
