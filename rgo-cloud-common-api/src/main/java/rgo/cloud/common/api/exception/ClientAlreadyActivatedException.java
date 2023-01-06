package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class ClientAlreadyActivatedException extends CoreException {
    public ClientAlreadyActivatedException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.ALREADY_ACTIVATED;
    }
}
