package nayoung.designpattern.app.proxy.basedOnInterface;

public interface OrderServiceV1 {
    void orderAndPrintLog(String itemId);
    void orderAndNoLog(String itemId);
}
