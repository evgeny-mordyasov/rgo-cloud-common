package rgo.cloud.common.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import rgo.cloud.common.api.exception.UnpredictableException;

public final class JsonUtil {
    private static final ObjectMapper OM = new ObjectMapper();

    private JsonUtil() {
    }

    public static String toJson(Object obj) {
        try {
            return OM.writeValueAsString(obj);
        } catch (Exception e) {
            throw new UnpredictableException("Failed to serialize the object: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
