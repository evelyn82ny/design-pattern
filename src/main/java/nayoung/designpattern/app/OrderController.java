package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.templateMethodPattern.AbstractTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final LogTrace trace;

    @GetMapping("/order")
    public String order(String itemId) {
        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String order() {
                orderService.order(itemId);
                return "order success";
            }
        };
        return template.execute("OrderController.order()");
    }
}
