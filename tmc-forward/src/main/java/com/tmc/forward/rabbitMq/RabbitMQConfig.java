package com.tmc.forward.rabbitMq;

/**
 * created by hongjian_he on 2017/9/10.
 */
public class RabbitMQConfig {
    public String host ="10.24.43.96";

    public int port =6379;

    public String username = "alidw";

    public String password = "alidw";

    public String virtualHost = "tmc";


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public void setVirtualHost(String virtualHost) {
        this.virtualHost = virtualHost;
    }
}
