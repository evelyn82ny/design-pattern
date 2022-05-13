package nayoung.designpattern.app.proxy.componentscan;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceV3 {

    private final ItemRepositoryV3 itemRepository;

    public OrderServiceV3(ItemRepositoryV3 itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void orderAndPrintLog(String itemId) {
        itemRepository.orderAndPrintLog(itemId);
    }

    public void orderAndNoLog(String itemId) {
        itemRepository.orderAndNoLog(itemId);
    }
}
