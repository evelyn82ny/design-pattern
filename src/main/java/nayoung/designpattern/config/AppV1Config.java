package nayoung.designpattern.config;

import nayoung.designpattern.app.proxy.basedOnInterface.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppV1Config {

    @Bean
    public OrderControllerV1 controllerV1() {
        return new OrderControllerV1Impl(orderServiceV1());
    }

    @Bean
    public OrderServiceV1 orderServiceV1() {
        return new OrderServiceV1Impl(itemRepositoryV1());
    }

    @Bean
    public ItemRepositoryV1 itemRepositoryV1() {
        return new ItemRepositoryV1Impl();
    }
}
