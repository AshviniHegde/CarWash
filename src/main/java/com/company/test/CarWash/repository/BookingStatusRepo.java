package com.company.test.CarWash.repository;

import com.company.test.CarWash.entity.BookingStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;

@Repository
@Transactional
public interface BookingStatusRepo extends CrudRepository<BookingStatus, Integer> {

    @Query(value = "Select count(*) from booking_status b " +
            "JOIN car_wash_place c on b.shop_id = c.shop_id " +
            "where b.booking_date = :date && c.shop_id =:shopId", nativeQuery = true)
    Integer getBookingsByDateAndPlace(Date date, Integer shopId);
}
