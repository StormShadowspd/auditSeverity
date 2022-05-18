package com.audit.severity.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;


/**
 * 
 * This feign client is used to call methods of audit checklist microservice
 */
@FeignClient(name = "audit-checklist", url = "${audit.checklist.url}")
public interface AuditCheckListFeign {

	@PostMapping("/checklist/{auditType}")
	public ResponseEntity<?> getQuestions(
			@RequestHeader(name = "Authorization", required = true) String token, @PathVariable String auditType);

}
