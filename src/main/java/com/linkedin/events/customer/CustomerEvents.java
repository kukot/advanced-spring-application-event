package com.linkedin.events.customer;

public class CustomerEvents {

    public record CustomerRegisteredEvent(Customer customer) {

    }

    public record CustomerRemovedEvent(Customer customer) {

    }
}
