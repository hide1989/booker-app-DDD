package booker.app.shared.infrastructure.bus.event;

import booker.app.shared.domain.Service;
import booker.app.shared.domain.bus.event.DomainEvent;
import booker.app.shared.domain.bus.event.EventBus;
import org.springframework.context.ApplicationEventPublisher;

import java.util.List;

@Service
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }


    @Override
    public void publish(List<DomainEvent<?>> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event){
        this.publisher.publishEvent(event);
    }

}
