package rgo.cloud.common.api.rest;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EmptySuccessfulResponse implements Response {
    private final Status status = Status.success();
    private final Object object = null;
}
