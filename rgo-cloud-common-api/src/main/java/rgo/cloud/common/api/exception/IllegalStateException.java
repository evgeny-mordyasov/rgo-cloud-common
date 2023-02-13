package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class IllegalStateException extends CoreException {
    public IllegalStateException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.ILLEGAL_STATE;
    }

    @Override
    public int httpCode() {
        return 400;
    }
}
