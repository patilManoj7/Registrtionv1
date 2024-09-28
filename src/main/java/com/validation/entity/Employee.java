package com.validation.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(unique = true,nullable = false,length = 10)
    private String phone;
    @Column(nullable = false)
    private Long salary;
   @Column
    private String address;
}
