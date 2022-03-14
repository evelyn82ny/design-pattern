package nayoung.designpattern.app.proxy.basedOnInterface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ItemRepositoryV1 {

    Map<String, Long> items = new ConcurrentHashMap<>();

    void orderAndPrintLog(String itemId);
    void orderAndNoLog(String itemId);
    void save(String itemId, Long stock);
}
