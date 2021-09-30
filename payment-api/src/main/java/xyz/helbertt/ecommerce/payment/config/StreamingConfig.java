package xyz.helbertt.ecommerce.payment.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import xyz.helbertt.ecommerce.payment.streaming.CheckoutProcessor;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
}
