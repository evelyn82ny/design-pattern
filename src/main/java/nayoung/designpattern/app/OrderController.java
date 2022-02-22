package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.trace.callback.TraceTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final TraceTemplate template;

    @GetMapping("/order")
    public String order(String itemId) {
        return template.execute("OrderController.order()", () -> {
            orderService.order(itemId);
            return "order success";
        });
    }
}
