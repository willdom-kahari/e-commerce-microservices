package com.waduclay.ecommerce.kafka;



import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author <a href="mailto:developer.wadu@gmail.com">Willdom Kahari</a>
 */
@Configuration
public class PaymentTopicConfig {

    @Bean
    public NewTopic paymentTopic(){
        return TopicBuilder.name("payment-topic").build();
    }
}
