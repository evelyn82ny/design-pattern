package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final LogTrace trace;

    @GetMapping("/order")
    public String order(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.order()");
            orderService.order(itemId);
            trace.end(status);
            return "order success";
        } catch(Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
