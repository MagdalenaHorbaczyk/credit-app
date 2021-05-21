package com.creditapp.productservice.repositories;

import com.creditapp.productservice.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {
    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    Boolean existsByCreditId(Long creditId);
}
