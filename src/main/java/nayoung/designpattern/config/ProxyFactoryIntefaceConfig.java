package nayoung.designpattern.config;

import lombok.extern.slf4j.Slf4j;
import nayoung.designpattern.app.proxy.basedOnInterface.*;
import nayoung.designpattern.config.advice.LogTraceAdvice;
import nayoung.designpattern.trace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ProxyFactoryIntefaceConfig {

    @Bean
    public OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        OrderControllerV1 orderController = new OrderControllerV1Impl(orderServiceV1(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(orderController);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        OrderControllerV1 proxy = (OrderControllerV1) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderController.getClass());
        return proxy;
    }

    @Bean
    public OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        OrderServiceV1 orderService = new OrderServiceV1Impl(itemRepositoryV1(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(orderService);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        OrderServiceV1 proxy = (OrderServiceV1) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderService.getClass());
        return proxy;
    }

    @Bean
    public ItemRepositoryV1 itemRepositoryV1(LogTrace logTrace) {
        ItemRepositoryV1 itemRepository = new ItemRepositoryV1Impl();

        ProxyFactory proxyFactory = new ProxyFactory(itemRepository);
        proxyFactory.addAdvisor(getAdvisor(logTrace));

        ItemRepositoryV1 proxy = (ItemRepositoryV1) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), itemRepository.getClass());
        return proxy;
    }

    private Advisor getAdvisor(LogTrace logTrace) {
        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
        pointcut.setMappedName("*PrintLog");
        LogTraceAdvice advice = new LogTraceAdvice(logTrace);
        return new DefaultPointcutAdvisor(pointcut, advice);
    }
}
