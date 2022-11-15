package com.company.test.CarWash.entity;


import com.company.test.CarWash.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="credentials")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id", unique = true)
    Integer user_id;

    @Column(name = "password")
    String password;

    @Column(name = "userType")
    UserType userType;
}

