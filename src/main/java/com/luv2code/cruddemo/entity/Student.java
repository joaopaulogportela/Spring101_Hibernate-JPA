package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnCloudPlatform;

@Entity
@Table(name="student")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}
