package nayoung.designpattern.app.proxy.componentscan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@ResponseBody
@RestController
public class OrderControllerV3 {

    private final OrderServiceV3 orderService;

    public OrderControllerV3(OrderServiceV3 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v3/order-printLog")
    public String orderAndPrintLog(String itemId) {
        orderService.orderAndPrintLog(itemId);
        return "order success";
    }

    @GetMapping("/v3/order-noLog")
    public String orderAndNoLog(String itemId) {
        orderService.orderAndNoLog(itemId);
        return "order success";
    }
}
