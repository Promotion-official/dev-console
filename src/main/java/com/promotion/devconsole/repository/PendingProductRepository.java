package com.promotion.devconsole.repository;

import com.promotion.devconsole.entity.PendingProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PendingProductRepository extends JpaRepository<PendingProduct, Integer> {
}