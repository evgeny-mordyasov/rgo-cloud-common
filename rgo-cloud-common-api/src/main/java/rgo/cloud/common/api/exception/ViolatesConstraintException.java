package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class ViolatesConstraintException extends CoreException {
    public ViolatesConstraintException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.VIOLATES_CONSTRAINT;
    }

    @Override
    public int httpCode() {
        return 400;
    }
}
