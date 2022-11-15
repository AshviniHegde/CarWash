package com.company.test.CarWash.controllers;


import com.company.test.CarWash.entity.BookingStatus;
import com.company.test.CarWash.entity.CarWashPlace;
import com.company.test.CarWash.enums.BookingStatusEnum;
import com.company.test.CarWash.repository.BookingStatusRepo;
import com.company.test.CarWash.repository.CarWashRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
public class CarWashController {

    @Autowired
    CarWashRepo carWashRepo;

    @Autowired
    BookingStatusRepo bookingStatusRepo;

    @RequestMapping(method = RequestMethod.GET,value = "/search")
    public List<CarWashPlace> searchForCarWash(@RequestParam String place){
        List<CarWashPlace> carWashPlaceList = carWashRepo.getCarWashInfoByPlace(place);
        return carWashPlaceList;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getTheBookingStatus")
    public BookingStatusEnum getBookingStatus(@RequestParam Integer bookingId){
        return bookingStatusRepo.findById(bookingId).get().getBookingStatus();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doBooking")
    public boolean doBooking(@RequestParam Integer shopId, @RequestParam Integer userId, @RequestParam Date date){
        BookingStatus obj = BookingStatus.builder()
                .bookingDate(date)
                .bookingStatus(BookingStatusEnum.ACCEPTED)
                .userId(userId)
                .shopId(shopId)
                .build();

        if(bookingStatusRepo.getBookingsByDateAndPlace(date, shopId)< 5){
            bookingStatusRepo.save(obj);
            return true;
        }
        else return false;
    }
}
