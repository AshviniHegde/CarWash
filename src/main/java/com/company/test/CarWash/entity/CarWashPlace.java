package com.company.test.CarWash.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "car_wash_place")
public class CarWashPlace {

    @Column(name = "shop_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer shopId;

    @Column(name = "shop_name")
    String shopName;

    @Column(name = "place")
    String place;
}
