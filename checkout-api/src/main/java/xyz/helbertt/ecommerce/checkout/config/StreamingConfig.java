package xyz.helbertt.ecommerce.checkout.config;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
import xyz.helbertt.ecommerce.checkout.streaming.CheckoutCreatedSource;
import xyz.helbertt.ecommerce.checkout.streaming.PaymentPaidSink;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
