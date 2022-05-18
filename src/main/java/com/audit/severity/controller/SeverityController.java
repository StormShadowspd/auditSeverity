package com.audit.severity.controller;

import java.util.ArrayList;
import java.util.List;

import com.audit.severity.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.audit.severity.model.AuditRequest;
import com.audit.severity.model.AuditResponse;
import com.audit.severity.service.SeverityService;

@RestController
@CrossOrigin
public class SeverityController {

	@Autowired
	private SeverityService service;

	@Autowired
	private TokenService tokenService;

	@PostMapping(value="/ProjectExecutionStatus", consumes = "application/json")
	private ResponseEntity<?> GetProjectExecutionStatus(@RequestHeader(value = "Authorization") String token,
														@RequestBody AuditRequest auditRequest) {

		ResponseEntity<?> responseEntity;
		boolean isValid = tokenService.checkTokenValidity(token);
		if (!isValid) {
			responseEntity = new ResponseEntity<String>("tokenExpired",
					HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		AuditResponse auditResponse = service.getProjectExecutionStatus(auditRequest);
		responseEntity = new ResponseEntity<AuditResponse>(auditResponse, HttpStatus.OK);
		
		
//		HttpHeaders responseHeaders = new HttpHeaders();
//	    responseHeaders.set("Access-Control-Allow-Origin", "*");

	    responseEntity = ResponseEntity.ok().body(auditResponse);
		return responseEntity;
	}
	
	@GetMapping("/health")
	public ResponseEntity<?> getHealthCheck() {
		return ResponseEntity.ok().body("ok");
	}
}
