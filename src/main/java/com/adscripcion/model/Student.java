package com.adscripcion.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;

    @Transient
    private int age;
    
    public LocalDate getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name !=null && name.length() > 0 && !Objects.equals(this.name,name)) {
            this.name = name;
        }
        
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        if(email !=null && email.length() > 0 && !Objects.equals(this.email,email)) {
            this.email = email;
        }
        
    }
    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }
    public void setAge(int age) {
        this.age = age;
    }   
    

    
}
