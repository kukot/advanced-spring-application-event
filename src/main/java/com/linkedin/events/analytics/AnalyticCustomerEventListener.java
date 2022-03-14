package com.linkedin.events.analytics;

import com.linkedin.events.customer.CustomerEvents;
import lombok.Data;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@Data
public class AnalyticCustomerEventListener {

    private final AnalyticsService analyticsService;

    @EventListener
    @Async
    public void onCustomerRegisteredListener(CustomerEvents.CustomerRegisteredEvent event) {
        analyticsService.registerNewCustomer(event.customer());
    }
}
