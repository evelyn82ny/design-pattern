package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ItemRepository itemRepository;
    private final LogTrace trace;

    public void order(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.order()");
            itemRepository.order(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
