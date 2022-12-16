package rgo.cloud.common.api.exception;

import rgo.cloud.common.api.rest.StatusCode;

public abstract class CoreException extends RuntimeException {
    public CoreException(String message) {
        super(message);
    }

    public abstract StatusCode code();
}
