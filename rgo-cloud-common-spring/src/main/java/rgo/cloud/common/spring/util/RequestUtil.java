package rgo.cloud.common.spring.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rgo.cloud.common.api.exception.CoreException;
import rgo.cloud.common.api.rest.BaseErrorResponse;
import rgo.cloud.common.api.rest.Response;

import java.util.function.Supplier;

import static rgo.cloud.common.api.rest.BaseErrorResponse.handleException;

@Slf4j
public final class RequestUtil {
    public static final String JSON = "application/json;charset=UTF-8";

    private RequestUtil() {
    }

    public static ResponseEntity<Response> execute(Supplier<Response> action) {
        try {
            Response response = action.get();
            log.info("Success response: {}", response);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return errorResponse(e);
        }
    }

    public static ResponseEntity<Response> errorResponse(Exception e) {
        BaseErrorResponse er = handleException(e);
        HttpStatus httpStatus = resolve(e);
        log.error("Error response: {}. HttpStatus: {}", er, httpStatus, e);
        return new ResponseEntity<>(er, httpStatus);
    }

    private static HttpStatus resolve(Exception e) {
        if (e instanceof CoreException) {
            CoreException ce = (CoreException) e;
            return HttpStatus.valueOf(ce.httpCode());
        }

        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
