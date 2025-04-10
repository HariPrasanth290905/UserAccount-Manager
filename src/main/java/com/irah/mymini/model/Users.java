package com.irah.mymini.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Data
@Entity
public class Users {

    private int ssn;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDate updated;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate created;

    private String active = "Y";

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    private String gender;
    private Long mobile;
    private String email;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public String toString() {
        return "Users{" +
                "ssn=" + ssn +
                ", updated=" + updated +
                ", created=" + created +
                ", active='" + active + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                ", mobile=" + mobile +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
