package com.creditapp.customerservice.repositories;

import com.creditapp.customerservice.entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CustomersRepository extends CrudRepository<Customer, Long> {
    @Override
    List<Customer> findAll();

    @Override
    Customer save(Customer customer);

    Boolean existsByCreditId(Long creditId);
}
