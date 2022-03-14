package com.linkedin.events.order;

public class OrderEvents {

    public record OrderCompletedEvent(Order order) {}
}
