package nayoung.designpattern.app.proxy.basedOnInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderControllerV1Impl implements OrderControllerV1 {

    private final OrderServiceV1 orderService;

    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String orderAndPrintLog(String itemId) {
        orderService.orderAndPrintLog(itemId);
        return "order success";
    }

    @Override
    public String orderAndNoLog(String itemId) {
        orderService.orderAndNoLog(itemId);
        return "order success";
    }
}
