package com.linkedin.events.ticket;

import com.linkedin.events.order.OrderEvents;
import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@Data
public class TicketListener {

    private final TicketService ticketService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void onOrderFailCreation(OrderEvents.OrderCompletedEvent event) {
        ticketService.createTicket(event.order());
    }
}
