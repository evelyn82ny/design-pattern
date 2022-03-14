package nayoung.designpattern.config;

import nayoung.designpattern.app.proxy.basedOnInterface.*;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.LogTraceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class JdkDynamicProxyConfig {

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        OrderControllerV1 orderController = new OrderControllerV1Impl(orderServiceV1(logTrace));
        OrderControllerV1 proxy = (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader(),
                new Class[]{OrderControllerV1.class}, new LogTraceHandler(orderController, logTrace));
        return proxy;
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        OrderServiceV1 orderService = new OrderServiceV1Impl(itemRepositoryV1(logTrace));
        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader(),
                new Class[]{OrderServiceV1.class}, new LogTraceHandler(orderService, logTrace));
        return proxy;
    }

    @Bean
    public ItemRepositoryV1 itemRepositoryV1(LogTrace logTrace) {
        ItemRepositoryV1 itemRepository = new ItemRepositoryV1Impl();
        ItemRepositoryV1 proxy = (ItemRepositoryV1) Proxy.newProxyInstance(ItemRepositoryV1.class.getClassLoader(),
                new Class[]{ItemRepositoryV1.class}, new LogTraceHandler(itemRepository, logTrace));
        return proxy;
    }
}
