package com.tmc.forward.rabbitMq;

import com.rabbitmq.client.Address;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by huangyu on 2017/8/22.
 */
@Component
public abstract class BaseMQConn extends RabbitMQConfig {
    private Connection connection;

    private Channel channel;

    public BaseMQConn(){
        try {
            this.initConnection();
            this.initChannel();
        } catch (IOException e) {
        } catch (TimeoutException e) {
        }
    }

    protected void initConnection() throws IOException, TimeoutException {
        if(this.connection == null){
            ConnectionFactory factory = new ConnectionFactory();

            factory.setUsername(this.username);
            factory.setPassword(this.password);
            factory.setVirtualHost(this.virtualHost);
            factory.setPort(this.port);
            this.connection = factory.newConnection(Address.parseAddresses(this.host));
        }
    }

    protected void initChannel() throws IOException {
        if(null == this.channel){
            if(null == this.connection){
                throw new IOException("mq连接为空");
            }
            this.channel = this.connection.createChannel();
        }

    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}