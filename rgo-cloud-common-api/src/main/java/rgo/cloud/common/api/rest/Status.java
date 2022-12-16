package rgo.cloud.common.api.rest;

public class Status {
    private final StatusCode code;
    private final String description;

    private Status(StatusCode code) {
        this.code = code;
        this.description = null;
    }

    public Status(StatusCode code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Status success() {
        return new Status(StatusCode.SUCCESS);
    }

    public static Status error(String msg) {
        return new Status(StatusCode.CALL_ERROR, msg);
    }

    public StatusCode getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Status{" +
                "code=" + code +
                ", description='" + description + '\'' +
                '}';
    }
}