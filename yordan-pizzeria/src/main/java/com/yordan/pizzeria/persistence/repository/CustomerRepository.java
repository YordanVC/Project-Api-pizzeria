package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;


public interface CustomerRepository extends ListCrudRepository<CustomerEntity,String> {
    //metodo con la anotacion @Query
    @Query(value = "SELECT c FROM CustomerEntity c WHERE c.phoneNumber =:phone")
    CustomerEntity findByPhone(@Param("phone") String phone);
}
