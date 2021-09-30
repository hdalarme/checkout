package xyz.helbertt.ecommerce.checkout.Service;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import xyz.helbertt.ecommerce.checkout.Entity.CheckoutEntity;
import xyz.helbertt.ecommerce.checkout.Repository.CheckoutRepositoty;
import xyz.helbertt.ecommerce.checkout.resource.CheckoutRequest;
import xyz.helbertt.ecommerce.checkout.streaming.CheckoutCreatedSource;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final CheckoutRepositoty checkoutRepositoty;
    private final CheckoutCreatedSource checkoutCreatedSource;

    /*
    public CheckoutServiceImpl(CheckoutRepositoty checkoutRepositoty) {
        this.checkoutRepositoty = checkoutRepositoty;
    }
    */

    @Override
    public Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest) {
        final CheckoutEntity checkoutEntity = CheckoutEntity.builder()
                .code(UUID.randomUUID().toString())
                .status(CheckoutEntity.Status.CREATED)
                .build();
        final CheckoutEntity entity = checkoutRepositoty.save(checkoutEntity);

        final CheckoutCreatedEvent checkoutCreatedEvent = CheckoutCreatedEvent.newBuilder()
                .setCheckoutCode(entity.getCode())
                .setStatus(entity.getStatus().name())
                .build();
        checkoutCreatedSource.output().send(MessageBuilder.withPayload(checkoutCreatedEvent).build());

        return Optional.of(checkoutRepositoty.save(entity));
    }
}
