package nayoung.designpattern.config.basedonconcreatedclass;

import lombok.extern.slf4j.Slf4j;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.*;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.proxy.ItemRepositoryV2ConCreteProxy;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.proxy.OrderControllerV2ConcreteProxy;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.proxy.OrderServiceV2ConcreteProxy;
import nayoung.designpattern.trace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppV2ConcreteProxyConfig {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 orderController = new OrderControllerV2(orderServiceV2(logTrace));
        return new OrderControllerV2ConcreteProxy(orderController, logTrace);
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 orderService = new OrderServiceV2(itemRepositoryV2(logTrace));
        return new OrderServiceV2ConcreteProxy(orderService, logTrace);
    }

    @Bean
    public ItemRepositoryV2 itemRepositoryV2(LogTrace logTrace) {
        ItemRepositoryV2 itemRepository = new ItemRepositoryV2();
        return new ItemRepositoryV2ConCreteProxy(itemRepository, logTrace);
    }
}
