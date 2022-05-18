package com.audit.severity.clients;

import com.audit.severity.model.AuthResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;


/**
 * 
 * This feign client is used to call methods of Authentication microservice
 */
@FeignClient(url = "${fos.auth}", name = "audit-authentication")
public interface AuthClient {

	@GetMapping(value = "/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token);

}