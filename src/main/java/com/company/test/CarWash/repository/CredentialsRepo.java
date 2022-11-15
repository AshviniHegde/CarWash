package com.company.test.CarWash.repository;


import com.company.test.CarWash.entity.Credentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CredentialsRepo extends CrudRepository<Credentials, Integer> {

    @Override
    List<Credentials> findAll();

}
