package nayoung.designpattern.app.proxy.basedOnInterface.proxy;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.app.proxy.basedOnInterface.OrderControllerV1;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;

@RequiredArgsConstructor
public class OrderControllerInterfaceProxy implements OrderControllerV1 {

    private final OrderControllerV1 target;
    private final LogTrace logTrace;

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

    @Override
    public String orderAndNoLog(String itemId) {
        return target.orderAndNoLog(itemId);
    }
}
