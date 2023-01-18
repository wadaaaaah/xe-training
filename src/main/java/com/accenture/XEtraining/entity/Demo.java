package com.accenture.XEtraining.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "demo")
@Data
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;
    String name;
    int age;
    Date joinedDate;
    boolean active;

}
