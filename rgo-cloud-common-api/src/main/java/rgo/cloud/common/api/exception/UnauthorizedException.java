package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class UnauthorizedException extends CoreException {
    public UnauthorizedException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.UNAUTHORIZED;
    }

    @Override
    public int httpCode() {
        return 401;
    }
}
