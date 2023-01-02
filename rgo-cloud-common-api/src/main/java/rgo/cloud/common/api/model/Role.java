package rgo.cloud.common.api.model;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Role {
    ANONYMOUS,
    USER,
    ADMIN;

    private static final Map<String, Role> roles = Arrays.stream(Role.values())
            .collect(Collectors.toMap(Role::name, Function.identity()));

    public static Role of(String role) {
        Role rs = roles.get(role.toUpperCase(Locale.getDefault()));

        if (rs == null) {
            throw new IllegalArgumentException("The role '" + role + "' not exists.");
        }

        return rs;
    }
}
