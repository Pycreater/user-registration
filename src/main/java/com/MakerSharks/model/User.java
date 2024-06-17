package com.MakerSharks.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Lombok;

/**
 * User entity representing a user in the system.
 * Lombok's @Data annotation generates getters, setters, toString, equals, and hashCode methods.
 */

@Entity
@Data
public class User {
    @Id             //used to specify a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //it helps generating this id automatically in increment order.
    private Long id;

    private String username;
    private String email;
    private String password;
}
