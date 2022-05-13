package nayoung.designpattern.config;

import nayoung.designpattern.app.proxy.basedOnConcreteClass.ItemRepositoryV2;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.OrderControllerV2;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.OrderServiceV2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV2Config {

    @Bean
    public OrderControllerV2 orderControllerV2() {
        return new OrderControllerV2(orderServiceV2());
    }

    @Bean
    public OrderServiceV2 orderServiceV2() {
        return new OrderServiceV2(orderRepositoryV2());
    }

    @Bean
    public ItemRepositoryV2 orderRepositoryV2() {
        return new ItemRepositoryV2();
    }
}