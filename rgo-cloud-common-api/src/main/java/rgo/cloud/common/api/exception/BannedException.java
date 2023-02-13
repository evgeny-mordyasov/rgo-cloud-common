package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class BannedException extends CoreException {
    public BannedException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.BANNED;
    }

    @Override
    public int httpCode() {
        return 403;
    }
}
