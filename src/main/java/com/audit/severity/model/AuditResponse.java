package com.audit.severity.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "auditresponse")
public class AuditResponse implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ResponseId")
	private int responseId;
	@Column(name = "ExecutionStatus")
	private String executionStatus;
	@Column(name = "ActionDuration")
	private String duration;
	@Column(name = "ProjectName")
	String projectName;
	@Column(name = "ManagerName")
	String managerName;
	@Column(name = "OwnerName")
	String ownerName;
	@Column(name = "AuditType")
	String auditType;
	@Column(name = "auditDate")
	Date auditDate;

}
