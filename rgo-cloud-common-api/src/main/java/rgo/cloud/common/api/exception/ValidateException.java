package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class ValidateException extends CoreException {
    public ValidateException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.INVALID_RQ;
    }

    @Override
    public int httpCode() {
        return 400;
    }
}
