package com.yordan.pizzeria.persistence.repository;

import com.yordan.pizzeria.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<UserEntity,String> {

}
