package com.audit.severity.repository;

import com.audit.severity.model.AuditRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<AuditRequest, Integer> {
}
