package nayoung.designpattern.app.proxy.basedOnConcreteClass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceV2 {

    private final ItemRepositoryV2 itemRepository;

    public OrderServiceV2(ItemRepositoryV2 itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void orderAndPrintLog(String itemId) {
        itemRepository.orderAndPrintLog(itemId);
    }

    public void orderAndNoLog(String itemId) {
        itemRepository.orderAndNoLog(itemId);
    }
}
