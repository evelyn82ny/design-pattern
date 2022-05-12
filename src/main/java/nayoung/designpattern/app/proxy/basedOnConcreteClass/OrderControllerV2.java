package nayoung.designpattern.app.proxy.basedOnConcreteClass;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
@ResponseBody
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;

    public OrderControllerV2(OrderServiceV2 orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/v2/order-printLog")
    public String orderAndPrintLog(String itemId) {
        orderService.orderAndPrintLog(itemId);
        return "order success";
    }

    @GetMapping("/v2/order-noLog")
    public String orderAndNoLog(String itemId) {
        orderService.orderAndNoLog(itemId);
        return "order success";
    }
}
