package nayoung.designpattern.config.proxyfactory;

import lombok.extern.slf4j.Slf4j;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.ItemRepositoryV2;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.OrderControllerV2;
import nayoung.designpattern.app.proxy.basedOnConcreteClass.OrderServiceV2;
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
public class ProxyFactoryConcreteClassConfig {

    @Bean
    public OrderControllerV2 orderControllerV2(LogTrace logTrace) {
        OrderControllerV2 orderController = new OrderControllerV2(orderServiceV2(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(orderController);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderControllerV2 proxy = (OrderControllerV2) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderController.getClass());
        return proxy;
    }

    @Bean
    public OrderServiceV2 orderServiceV2(LogTrace logTrace) {
        OrderServiceV2 orderService = new OrderServiceV2(itemRepositoryV2(logTrace));

        ProxyFactory proxyFactory = new ProxyFactory(orderService);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        OrderServiceV2 proxy = (OrderServiceV2) proxyFactory.getProxy();
        log.info("ProxyFactory proxy = {}, target = {}", proxy.getClass(), orderService.getClass());
        return proxy;
    }

    @Bean
    public ItemRepositoryV2 itemRepositoryV2(LogTrace logTrace) {
        ItemRepositoryV2 itemRepository = new ItemRepositoryV2();

        ProxyFactory proxyFactory = new ProxyFactory(itemRepository);
        proxyFactory.addAdvisor(getAdvisor(logTrace));
        ItemRepositoryV2 proxy = (ItemRepositoryV2) proxyFactory.getProxy();
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
