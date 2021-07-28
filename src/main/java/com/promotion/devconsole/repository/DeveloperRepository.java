package com.promotion.devconsole.repository;

import com.promotion.devconsole.domain.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, String> {
}
