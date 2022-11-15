package com.company.test.CarWash.repository;

import com.company.test.CarWash.entity.CarWashPlace;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarWashRepo extends CrudRepository<CarWashPlace, Integer> {

    @Query(value = "SELECT * FROM car_wash_place where place = :place", nativeQuery = true)
    List<CarWashPlace> getCarWashInfoByPlace(String place);
}
