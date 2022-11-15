package com.company.test.CarWash.entity;

import com.company.test.CarWash.enums.ServicesEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="service_data_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceDataTable {

    @Id
    @Column(name = "shop_id",unique = true, nullable = false)
    Integer shopId;

    @Column(name = "services_available", nullable = false)
    ServicesEnum services;
}
