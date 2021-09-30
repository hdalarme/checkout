package xyz.helbertt.ecommerce.checkout.Listener;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import xyz.helbertt.ecommerce.checkout.Entity.CheckoutEntity;
import xyz.helbertt.ecommerce.checkout.Repository.CheckoutRepositoty;
import xyz.helbertt.ecommerce.checkout.streaming.PaymentPaidSink;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutRepositoty checkoutRepositoty;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent event) {
        final CheckoutEntity checkoutEntity = checkoutRepositoty.findByCode(event.getCheckoutCode()).orElseThrow();
        checkoutEntity.setStatus(CheckoutEntity.Status.APPROVAD);
        checkoutRepositoty.save(checkoutEntity);
    }

}
