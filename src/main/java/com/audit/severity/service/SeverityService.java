package com.audit.severity.service;

import com.audit.severity.repository.RequestRepository;
import com.audit.severity.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.severity.model.AuditQuestion;
import com.audit.severity.model.AuditRequest;
import com.audit.severity.model.AuditResponse;

@Service
public class SeverityService {

	@Autowired
	RequestRepository requestRepository;

	@Autowired
	ResponseRepository responseRepository;

	public AuditResponse getProjectExecutionStatus(AuditRequest auditRequest) {
		int acceptableNos = 3;
		AuditResponse response = new AuditResponse();
		response.setOwnerName(auditRequest.getOwnerName());
		response.setManagerName(auditRequest.getManagerName());
		response.setProjectName(auditRequest.getProjectName());
		response.setAuditType(auditRequest.getAuditDetails().getAuditType());
		response.setAuditDate(auditRequest.getAuditDetails().getAuditDate());
		if (auditRequest.getAuditDetails().getQuestionNoCount() > acceptableNos) {
			response.setExecutionStatus("RED");
			response.setDuration("Action should be taken in 2 weeks");
		} else {
			response.setExecutionStatus("GREEN");
			response.setDuration("No Action requried");
		}
		requestRepository.save(auditRequest);
		return responseRepository.save(response);
	}

}
