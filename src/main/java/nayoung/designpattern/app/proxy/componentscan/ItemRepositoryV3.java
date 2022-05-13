package nayoung.designpattern.app.proxy.componentscan;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepositoryV3 {
    private static final Map<String, Long> items = new ConcurrentHashMap<>();

    public void orderAndPrintLog(String itemId) {
        if(!isExistItem(itemId)) {
            throw new IllegalStateException("상품 없음");
        }
        sleep(1000);
    }

    public void orderAndNoLog(String itemId) {
        if(!isExistItem(itemId)) {
            throw new IllegalStateException("상품 없음");
        }
        sleep(1000);
    }

    public void save(String itemId, Long stock) {
        items.put(itemId, stock);
    }

    private boolean isExistItem(String itemId) {
        return items.containsKey(itemId);
    }

    private void sleep(int millisecond) {
        try {
            Thread.sleep(millisecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
