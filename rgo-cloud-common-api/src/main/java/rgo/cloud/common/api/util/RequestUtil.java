package rgo.cloud.common.api.util;

import lombok.extern.slf4j.Slf4j;
import rgo.cloud.common.api.rest.Response;

import java.util.function.Supplier;

import static rgo.cloud.common.api.rest.BaseErrorResponse.handleException;

@Slf4j
public final class RequestUtil {
    public static final String JSON = "application/json;charset=UTF-8";

    private RequestUtil() {
    }

    public static Response execute(Supplier<Response> action) {
        Response response;

        try {
            response = action.get();
            log.info("Success response: {}", response);
        } catch (Exception e) {
            response = handleException(e);
            log.error("Error response: {}", response);
        }

        return response;
    }
}
