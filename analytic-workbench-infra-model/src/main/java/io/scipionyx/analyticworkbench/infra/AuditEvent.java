package io.scipionyx.analyticworkbench.infra;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class AuditEvent implements Serializable {

	private String action;

	private String description;

	private LocalDateTime date;

	private UserDetails user;

}
