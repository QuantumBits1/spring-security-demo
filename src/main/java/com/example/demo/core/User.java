package com.example.demo.core;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity
@Table
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement
public class User {
    @Id
    private Long id;
    private String name;
    private String idNum;
    private LocalDate dob;
    private Integer age;
    private College college;

    public User() {
        super();
    }

    public User(Long id, String name, String idNum, LocalDate dob, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.idNum = idNum;
        this.dob = dob;
        this.age = age;
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
        this.name = name;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idNum='" + idNum + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                ", college=" + college +
                '}';
    }
}
