package nayoung.designpattern.app.proxy.basedOnInterface.proxy;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.app.proxy.basedOnInterface.OrderServiceV1;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;

/*
@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderServiceV1 {

    private final OrderServiceV1 target;
    private final LogTrace logTrace;

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
*/