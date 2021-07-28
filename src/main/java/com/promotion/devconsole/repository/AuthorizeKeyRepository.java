package com.promotion.devconsole.repository;

import com.promotion.devconsole.domain.entity.AuthorizeKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizeKeyRepository extends JpaRepository<AuthorizeKey, String> {
}
