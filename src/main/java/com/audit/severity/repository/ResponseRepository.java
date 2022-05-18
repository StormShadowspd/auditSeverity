package com.audit.severity.repository;

import com.audit.severity.model.AuditDetails;
import com.audit.severity.model.AuditResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<AuditResponse, Integer> {
}
