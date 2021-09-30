package xyz.helbertt.ecommerce.checkout.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.helbertt.ecommerce.checkout.Entity.CheckoutEntity;

import java.util.Optional;

@Repository
public interface CheckoutRepositoty extends JpaRepository<CheckoutEntity, Long> {

    Optional<CheckoutEntity> findByCode(String code);

}
