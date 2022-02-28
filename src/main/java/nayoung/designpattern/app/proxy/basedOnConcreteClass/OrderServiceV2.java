package nayoung.designpattern.app.proxy.basedOnConcreteClass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderServiceV2 {

    private final ItemRepositoryV2 itemRepository;

    public OrderServiceV2(ItemRepositoryV2 itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void order(String itemId) {
        itemRepository.order(itemId);
    }
}
