package rgo.cloud.common.api.properties;

public interface DbProperties {
    String url();

    String schema();

    String username();

    String password();

    int maxPoolSize();
}
