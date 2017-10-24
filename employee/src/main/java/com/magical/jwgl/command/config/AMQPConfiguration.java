package com.magical.jwgl.command.config;

import org.slf4j.Logger;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by zhouxp on 2017/10/20.
 */
@Configuration
public class AMQPConfiguration {

    private static final Logger LOGGER = getLogger(AMQPConfiguration.class);

    @Value("${axon.amqp.exchange}")
    private String exchangeName;

    @Bean
    public Exchange exchange(){
        return ExchangeBuilder.fanoutExchange(exchangeName).durable(true).build();
    }


    @Bean
    public Queue queue(){
        return new Queue("empolyeequeue", true);
    }

    @Bean
    public Binding queueBinding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("").noargs();
    }

}
