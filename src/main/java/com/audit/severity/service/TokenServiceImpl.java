package com.audit.severity.service;

import com.audit.severity.clients.AuthClient;
import com.audit.severity.model.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
/**
 * 

 * This class is implementing {@link TokenService}.
 * The method of this class is used in other classes to validate token received.
 * 
 * @see AuthClient
 *
 */
@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

	/**
	 * Interface interacting with Auth microservice
	 */
	@Autowired
	private AuthClient authClient;
	/**
	 * @param token
	 * @return boolean this method will check the token validity by communicating
	 *         with auth client.
	 */
	public Boolean checkTokenValidity(String token) {
		log.info("start");
    	log.debug("token",token);
		try {
			log.debug("valid check success");
			AuthResponse authResponse = authClient.getValidity(token).getBody();
			if (authResponse == null)
				return false;
			log.info("end");
			return authResponse.isValid();
		} catch (FeignException e) {
			log.debug("validation failed");
			log.error("feign exception",e);
			log.info("end");
			return false;
		}

	}

}
