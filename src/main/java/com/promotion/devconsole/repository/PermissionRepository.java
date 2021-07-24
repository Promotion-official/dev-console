package com.promotion.devconsole.repository;

import com.promotion.devconsole.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, String> {
}
