package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class ClientAlreadyVerifiedException extends CoreException {
    public ClientAlreadyVerifiedException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.ALREADY_VERIFIED;
    }

    @Override
    public int httpCode() {
        return 400;
    }
}
