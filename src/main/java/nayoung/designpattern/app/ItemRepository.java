package nayoung.designpattern.app;

import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.callback.TraceTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ItemRepository {

    private Map<String, Long> items = new ConcurrentHashMap<>();
    private final TraceTemplate template;

    public ItemRepository(LogTrace trace) {
        this.template = new TraceTemplate(trace);
    }

    public void order(String itemId) {
        template.execute("ItemRepository.order()", () -> {
            if(!isExistItem(itemId)) {
                throw new IllegalStateException("상품 없음");
            }
            sleep(1000);
            return null;
        });
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

    public void save(String itemId, Long stock) {
        items.put(itemId, stock);
    }
}
