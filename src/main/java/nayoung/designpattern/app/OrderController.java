package nayoung.designpattern.app;

import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.callback.TraceTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderService orderService;
    private final TraceTemplate template;

    public OrderController(OrderService orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/order")
    public String order(String itemId) {
        return template.execute("OrderController.order()", () -> {
            orderService.order(itemId);
            return "order success";
        });
    }
}
