package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public class UnpredictableException extends CoreException {
    public UnpredictableException(String message) {
        super(message);
    }

    @Override
    public StatusCode code() {
        return StatusCode.CALL_ERROR;
    }
}
