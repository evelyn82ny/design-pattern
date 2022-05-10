package nayoung.designpattern.proxyfactory;

import lombok.extern.slf4j.Slf4j;
import nayoung.designpattern.JDKDynamicProxy.service.ServiceImpl;
import nayoung.designpattern.JDKDynamicProxy.service.ServiceInterface;
import nayoung.designpattern.advice.TimeAdvice;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;

@Slf4j
public class ProxyFactoryTest {

    @Test
    void interfaceProxy() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        log.info("target class = {}", target.getClass());
        log.info("proxy class = {}", proxy.getClass());

        proxy.save();

        Assertions.assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        Assertions.assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();
        Assertions.assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }
}
