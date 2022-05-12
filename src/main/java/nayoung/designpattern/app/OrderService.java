package nayoung.designpattern.app;

import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.callback.TraceTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final ItemRepository itemRepository;
    private final TraceTemplate template;

    public OrderService(ItemRepository itemRepository, LogTrace trace) {
        this.itemRepository = itemRepository;
        this.template = new TraceTemplate(trace);
    }

    public void order(String itemId) {
        template.execute("OrderService.order()", () -> {
            itemRepository.order(itemId);
            return null;
        });
    }
}
