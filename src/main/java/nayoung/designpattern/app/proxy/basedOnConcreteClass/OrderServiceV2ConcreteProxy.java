package nayoung.designpattern.app.proxy.basedOnConcreteClass;

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
    public void order(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderService.order()");
            target.order(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
