package xyz.helbertt.ecommerce.checkout.Service;

import xyz.helbertt.ecommerce.checkout.Entity.CheckoutEntity;
import xyz.helbertt.ecommerce.checkout.resource.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

}
