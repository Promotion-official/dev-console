package com.promotion.devconsole.repository;

import com.promotion.devconsole.entity.Api;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiRepository extends JpaRepository<Api, String> {
}
