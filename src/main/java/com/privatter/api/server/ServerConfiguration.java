package com.privatter.api.server;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "privatter.server")
public class ServerConfiguration {
    private String host;
    private String port;
    private String version;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getVersion() {
        return version;
    }
}
