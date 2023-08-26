package com.cqrs.demo.DAO;

import com.cqrs.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductQueryRepository extends JpaRepository<Product , Long> {
}
