package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.trace.callback.TraceTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;
    private final TraceTemplate template;

    public void order(String itemId) {
        template.execute("OrderService.order()", () -> {
            itemRepository.order(itemId);
            return null;
        });
    }
}
