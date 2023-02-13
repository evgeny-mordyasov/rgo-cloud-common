package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class EntityNotFoundException extends CoreException {
    public EntityNotFoundException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.ENTITY_NOT_FOUND;
    }

    @Override
    public int httpCode() {
        return 404;
    }
}
