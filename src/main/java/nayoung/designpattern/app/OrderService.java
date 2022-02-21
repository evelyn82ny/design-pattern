package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;
import nayoung.designpattern.trace.templateMethodPattern.AbstractTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;
    private final LogTrace trace;

    public void order(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void order() {
                itemRepository.order(itemId);
                return null;
            }
        };
        template.execute("OrderService.order()");
    }
}
