package com.audit.severity.repository;

import com.audit.severity.model.AuditDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditDetailRepository extends JpaRepository<AuditDetails, Integer> {
}
