package nayoung.designpattern.app.proxy.basedOnConcreteClass;

import org.springframework.beans.factory.InitializingBean;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ItemRepositoryV2 implements InitializingBean {

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

    @Override
    public void afterPropertiesSet() {
        items.put("apple", 34L);
        items.put("candy", 56L);
    }
}
