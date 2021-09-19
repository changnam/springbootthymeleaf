package com.honsoft.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "employees")
public class Employee {
    @Id 
    private Long name;

    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer age;
    private String designation;
    private double salary;
    private Date dateOfJoining;
}