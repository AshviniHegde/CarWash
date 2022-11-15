package com.company.test.CarWash.entity;

import com.company.test.CarWash.enums.BookingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="booking_status")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingStatus {

    @Column(name = "booking_id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer bookingId;

    @Column(name = "shopId")
    Integer shopId;

    @Column(name = "booking_date")
    Date bookingDate;

    @Column(name = "user_id")
    Integer userId;

    @Column(name = "booking_status")
    BookingStatusEnum bookingStatus;

}
