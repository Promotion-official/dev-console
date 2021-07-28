package com.promotion.devconsole.repository;

import com.promotion.devconsole.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
