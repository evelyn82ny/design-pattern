package nayoung.designpattern.app.proxy.basedOnInterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderControllerV1Impl implements OrderControllerV1 {

    private final OrderServiceV1 orderService;

    public OrderControllerV1Impl(OrderServiceV1 orderService) {
        this.orderService = orderService;
    }

    @Override
    public String order(String itemId) {
        orderService.order(itemId);
        return "order success";
    }
}
