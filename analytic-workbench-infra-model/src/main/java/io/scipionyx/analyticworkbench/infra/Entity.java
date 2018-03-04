package io.scipionyx.analyticworkbench.infra;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class Entity implements Serializable {

	private @Id String id;

	private Long version;

	private @CreatedDate LocalDateTime created;

	private @CreatedBy User createdBy;

	private @LastModifiedBy String lastModifiedBy;

	private @LastModifiedDate LocalDateTime lastModifiedDate;

	private Tenant tenant;

	private List<AuditEvent> auditEvents;

}
