package nayoung.designpattern.config.basedoninterface;

/*
import nayoung.designpattern.app.proxy.basedOnInterface.*;
import nayoung.designpattern.app.proxy.basedOnInterface.proxy.ItemRepositoryInterfaceProxy;
import nayoung.designpattern.app.proxy.basedOnInterface.proxy.OrderControllerInterfaceProxy;
import nayoung.designpattern.app.proxy.basedOnInterface.proxy.OrderServiceInterfaceProxy;
import nayoung.designpattern.trace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1InterfaceConfig {

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        OrderControllerV1Impl controllerV1Impl = new OrderControllerV1Impl(orderServiceV1(logTrace));
        return new OrderControllerInterfaceProxy(controllerV1Impl, logTrace);
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        OrderServiceV1Impl orderServiceV1Impl = new OrderServiceV1Impl(itemRepositoryV1(logTrace));
        return new OrderServiceInterfaceProxy(orderServiceV1Impl, logTrace);
    }

    @Bean
    public ItemRepositoryV1 itemRepositoryV1(LogTrace logTrace) {
        ItemRepositoryV1Impl itemRepositoryV1Impl = new ItemRepositoryV1Impl();
        return new ItemRepositoryInterfaceProxy(itemRepositoryV1Impl, logTrace);
    }
}
 */