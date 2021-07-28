package com.promotion.devconsole.repository;

import com.promotion.devconsole.domain.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
