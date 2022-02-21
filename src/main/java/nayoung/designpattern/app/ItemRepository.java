package nayoung.designpattern.app;

import lombok.RequiredArgsConstructor;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;
import nayoung.designpattern.trace.templateMethodPattern.AbstractTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private Map<String, Long> items = new ConcurrentHashMap<>();
    private final LogTrace trace;

    public void order(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void order() {
                if (!isExistItem(itemId)) {
                    throw new IllegalStateException("상품 없음");
                }
                sleep(1000);
                return null;
            }
        };
        template.execute("ItemRepository.order()");
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
