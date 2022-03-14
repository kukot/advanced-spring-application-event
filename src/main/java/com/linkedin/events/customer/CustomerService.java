package com.linkedin.events.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import static com.linkedin.events.customer.CustomerEvents.CustomerRegisteredEvent;
import static com.linkedin.events.customer.CustomerEvents.CustomerRemovedEvent;

@Component
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final ApplicationEventPublisher eventPublisher;

    public void register(Customer customer) {
        customerRepository.save(customer);
        CustomerRegisteredEvent event = new CustomerRegisteredEvent(customer);
        eventPublisher.publishEvent(event);
    }

    public void remove(Customer customer) {
        customerRepository.delete(customer);
        CustomerRemovedEvent removalEvent = new CustomerRemovedEvent(customer);
        eventPublisher.publishEvent(removalEvent);
    }
}
