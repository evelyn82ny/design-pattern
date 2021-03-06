package nayoung.designpattern.app.proxy.basedOnConcreteClass.proxy;

import nayoung.designpattern.app.proxy.basedOnConcreteClass.ItemRepositoryV2;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;

public class ItemRepositoryV2ConCreteProxy extends ItemRepositoryV2 {

    private final ItemRepositoryV2 target;
    private final LogTrace logTrace;

    public ItemRepositoryV2ConCreteProxy(ItemRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void orderAndPrintLog(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("ItemRepository.order()");
            target.orderAndPrintLog(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }
}
