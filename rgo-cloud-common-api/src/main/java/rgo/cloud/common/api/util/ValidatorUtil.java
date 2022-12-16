package rgo.cloud.common.api.util;

import rgo.cloud.common.api.exception.ValidateException;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

public final class ValidatorUtil {
    private ValidatorUtil() {
    }

    public static void errorString(String value, String fieldName) {
        if (isNull(value)) {
            error("The " + fieldName + " is null.");
        }

        if (isBlank(value)) {
            error("The " + fieldName + " is empty.");
        }
    }

    public static void errorEntityId(Long entityId) {
        errorId(entityId, "entityId");
    }

    public static void errorObjectId(Long objectId, String fieldName) {
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
        throw new ValidateException(message);
    }

    private static void errorId(Long objectId, String fieldName) {
        if (isNull(objectId)) {
            error("The " + fieldName + " is null.");
        }

        if (objectId < 1) {
            error("The " + fieldName + " is not positive.");
        }
    }
}
