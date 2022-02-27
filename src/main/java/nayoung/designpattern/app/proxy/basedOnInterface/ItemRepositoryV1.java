package nayoung.designpattern.app.proxy.basedOnInterface;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ItemRepositoryV1 {

    Map<String, Long> items = new ConcurrentHashMap<>();

    void order(String itemId);
    void save(String itemId, Long stock);
}
