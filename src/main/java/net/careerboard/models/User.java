package net.careerboard.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_account")
@Getter
@Setter
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;
    @Column(unique = true, nullable = false, length = 30, name = "username")
    @Size(min = 4, max = 30)
    String username;
    @Column(name = "first_name", nullable = false)
    @Size(max = 30)
    String firstName;
    @Column(name = "last_name", nullable = false)
    @Size(max = 30)
    String lastName;
    @Column(nullable = false, updatable = false, name = "created_at")
    LocalDateTime createdAt;
    @Column(nullable = false, name = "active")
    Boolean active;
    public User(){
        this.active = true; // default value
        this.createdAt = LocalDateTime.now(); // default value
    }
    public User(String username, String firstName, String lastName) {
        super();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
