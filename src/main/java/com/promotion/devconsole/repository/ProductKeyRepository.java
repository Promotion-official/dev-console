package com.promotion.devconsole.repository;

import com.promotion.devconsole.domain.entity.ProductKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductKeyRepository extends JpaRepository<ProductKey, Long> {
}
