package xyz.helbertt.ecommerce.checkout.streaming;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@Deprecated
public interface  PaymentPaidSink {

    String INPUT = "payment-paid-input";

    @Input(INPUT)
    SubscribableChannel input();

}
