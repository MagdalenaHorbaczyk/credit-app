package com.creditapp.creditservice.repositories;

import com.creditapp.creditservice.entities.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CreditsRepository extends CrudRepository<Credit, Long> {
    @Override
    List<Credit> findAll();

    @Override
    Credit save(Credit credit);
}
