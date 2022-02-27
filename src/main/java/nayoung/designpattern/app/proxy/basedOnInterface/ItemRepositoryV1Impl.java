package nayoung.designpattern.app.proxy.basedOnInterface;

public class ItemRepositoryV1Impl implements ItemRepositoryV1 {

    @Override
    public void order(String itemId) {
        if(!isExistItem(itemId)) {
            throw new IllegalStateException("상품 없음");
        }
        sleep(1000);
    }

    @Override
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
