package xyz.helbertt.ecommerce.checkout.streaming;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@Deprecated
public interface  CheckoutCreatedSource {

    String OUTPUT = "checkout-created-output";

    @Output(OUTPUT)
    MessageChannel output();

}
