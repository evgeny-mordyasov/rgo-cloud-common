package rgo.cloud.common.api.util;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.Nullable;
import rgo.cloud.common.api.exception.ValidateException;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

public final class ValidatorUtil {
    private static final ThreadLocal<StringBuilder> ERROR_MESSAGES =
            ThreadLocal.withInitial(() -> new StringBuilder(StringUtils.EMPTY));

    private ValidatorUtil() {
    }

    public static void finish() {
        String errors = ERROR_MESSAGES.get().toString().strip();
        ERROR_MESSAGES.remove();

        if (!errors.isBlank()) {
            throw new ValidateException(errors);
        }
    }

    public static void errorString(@Nullable String value, String fieldName) {
        if (isNull(value)) {
            error("The " + fieldName + " is null.");
            return;
        }

        if (isBlank(value)) {
            error("The " + fieldName + " is empty.");
        }
    }

    public static void errorEntityId(@Nullable Long entityId) {
        errorId(entityId, "entityId");
    }

    public static void errorObjectId(@Nullable Long objectId, String fieldName) {
       errorId(objectId, fieldName);
    }

    public static void errorTrue(boolean value, String message) {
        if (value) {
            error(message);
        }
    }

    public static void errorFalse(boolean value, String message) {
        if (!value) {
            error(message);
        }
    }

    private static void error(String message) {
        ERROR_MESSAGES.set(
                ERROR_MESSAGES.get()
                        .append(message)
                        .append(StringUtils.SPACE));
    }

    private static void errorId(Long objectId, String fieldName) {
        if (isNull(objectId)) {
            error("The " + fieldName + " is null.");
            return;
        }

        if (objectId < 1) {
            error("The " + fieldName + " is not positive.");
        }
    }
}
