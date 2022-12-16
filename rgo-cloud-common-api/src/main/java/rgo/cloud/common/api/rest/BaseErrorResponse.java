package rgo.cloud.common.api.rest;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.exception.ExceptionUtils;
import rgo.cloud.common.api.exception.CoreException;

@Getter
@ToString
public class BaseErrorResponse implements Response {
    private final Status status;

    private BaseErrorResponse(Status status) {
        this.status = status;
    }

    public static BaseErrorResponse handleException(Exception e) {
        if (e instanceof CoreException) {
            CoreException ce = (CoreException) e;
            return new BaseErrorResponse(new Status(ce.code(), ce.getMessage()));
        }

        return new BaseErrorResponse(Status.error(ExceptionUtils.getStackTrace(e)));
    }
}
