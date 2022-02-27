package nayoung.designpattern.app.proxy.basedOnInterface;

public class OrderServiceV1Impl implements OrderServiceV1 {

    private final ItemRepositoryV1 itemRepository;

    public OrderServiceV1Impl(ItemRepositoryV1 itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public void order(String itemId) {
        itemRepository.order(itemId);
    }

}
