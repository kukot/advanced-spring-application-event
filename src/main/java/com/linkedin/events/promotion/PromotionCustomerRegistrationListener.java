package com.linkedin.events.promotion;

import com.linkedin.events.customer.CustomerEvents;
import lombok.Data;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Data
public class PromotionCustomerRegistrationListener {

    private final PromotionService promotionService;

    @EventListener(condition = "#event.customer().newsletter")
    public void onNewCustomerRegistered(CustomerEvents.CustomerRegisteredEvent event) {
        promotionService.applyPromotion(event.customer());
    }
}
