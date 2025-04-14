package org.example.relationship.oneToOne.repository;

import org.example.relationship.oneToOne.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicenseRepository extends JpaRepository<License,Long> {
}
