package nayoung.designpattern.app.proxy.basedOnConcreteClass.proxy;

import nayoung.designpattern.app.proxy.basedOnConcreteClass.OrderServiceV2;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;

public class OrderServiceV2ConcreteProxy extends OrderServiceV2 {

    private final OrderServiceV2 target;
    private final LogTrace logTrace;

    public OrderServiceV2ConcreteProxy(OrderServiceV2 target, LogTrace logTrace) {
        super(null);
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderAndPrintLog(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.order()");
            target.orderAndPrintLog(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
