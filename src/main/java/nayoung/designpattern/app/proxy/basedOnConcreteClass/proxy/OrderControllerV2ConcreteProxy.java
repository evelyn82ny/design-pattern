package nayoung.designpattern.app.proxy.basedOnConcreteClass.proxy;

import nayoung.designpattern.app.proxy.basedOnConcreteClass.OrderControllerV2;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;

public class OrderControllerV2ConcreteProxy extends OrderControllerV2 {

    private final OrderControllerV2 target;
    private final LogTrace logTrace;

    public OrderControllerV2ConcreteProxy(OrderControllerV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public String orderAndPrintLog(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderController.order()");
            String result = target.orderAndPrintLog(itemId);
            logTrace.end(status);
            return result;
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
