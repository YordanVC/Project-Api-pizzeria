package com.yordan.pizzeria.service;

import com.yordan.pizzeria.persistence.entity.CustomerEntity;
import com.yordan.pizzeria.persistence.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService{
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    //metodo que retora la lista de customers
    public List<CustomerEntity> findAll(){
        return this.customerRepository.findAll();
    }
    //metodo que retorna un customer buscado por ID
    public Optional<CustomerEntity> findById(String id){
        return this.customerRepository.findById(id);
    }

    //metodo retorna un customer buscado por numero de telefono
    public CustomerEntity findByPhone(String phone){
        return this.customerRepository.findByPhone(phone);
    }
}
