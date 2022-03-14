package com.linkedin.events.email;

import lombok.Data;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import static com.linkedin.events.customer.CustomerEvents.CustomerRegisteredEvent;
import static com.linkedin.events.customer.CustomerEvents.CustomerRemovedEvent;

@Component
@Data
public class EmailListener {

    private final EmailService emailService;

    @EventListener
    public void onCustomerRegistered(CustomerRegisteredEvent event) {
        emailService.sendRegisterEmail(event.customer());
        System.out.println("Customer registered: " + event.customer().getId() + " has been registered with email: " + event.customer().getEmail());
    }

    @EventListener
    public void onCustomerRemoved(CustomerRemovedEvent event) {
        emailService.sendCustomerRemovedEmail(event.customer());
        System.out.println("Customer removed: " + event.customer().getId() + " has been removed with email: " + event.customer().getEmail());
    }
}
