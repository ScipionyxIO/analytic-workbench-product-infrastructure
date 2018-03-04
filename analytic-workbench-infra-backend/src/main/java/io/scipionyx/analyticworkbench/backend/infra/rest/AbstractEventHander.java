package io.scipionyx.analyticworkbench.backend.infra.rest;

import java.util.UUID;

import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeLinkDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import io.scipionyx.analyticworkbench.infra.Entity;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RepositoryEventHandler
public abstract class AbstractEventHander<ENTITY extends Entity> {

	// private @Autowired SecurityContext context;

	@HandleBeforeSave
	public void handleSave(ENTITY t) {
		log.debug("HandleBeforeSave");
		t.setVersion(t.getVersion() + 1);
		// t.setLastModifiedDate(LocalDateTime.from(Calendar.getInstance().getTime()));
		// context.getAuthentication().getPrincipal();
	}

	@HandleBeforeCreate
	public void handleCreate(ENTITY t) {
		log.debug("HandleBeforeCreate");
		t.setId(UUID.randomUUID().toString());
		// t.setCreated(Calendar.getInstance().getTime());
		t.setVersion(1l);
	}

	@HandleBeforeDelete
	public void handleDelete(ENTITY t) {
		log.debug("HandleBeforeDelete");
	}

	@HandleBeforeLinkDelete
	public void handleLinkDelete(ENTITY t) {
	}

}
