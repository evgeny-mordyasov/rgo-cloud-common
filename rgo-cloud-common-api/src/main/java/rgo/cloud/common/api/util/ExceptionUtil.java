package rgo.cloud.common.api.util;

import lombok.extern.slf4j.Slf4j;
import rgo.cloud.common.api.exception.UnpredictableException;

@Slf4j
public final class ExceptionUtil {
    private ExceptionUtil() {
    }

    public static void unpredictableError(String errorMsg) {
        log.error(errorMsg);
        throw new UnpredictableException(errorMsg);
    }
}
