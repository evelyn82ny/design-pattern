package nayoung.designpattern.app.proxy.basedOnInterface.proxy;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.app.proxy.basedOnInterface.ItemRepositoryV1;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;

/*
@RequiredArgsConstructor
public class ItemRepositoryInterfaceProxy implements ItemRepositoryV1 {

    private final ItemRepositoryV1 target;
    private final LogTrace logTrace;

    @Override
    public void order(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("ItemRepository.order()");
            target.order(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public void save(String itemId, Long stock) {
        items.put(itemId, stock);
    }
}
*/