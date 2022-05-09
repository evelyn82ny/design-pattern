package nayoung.designpattern.JDKDynamicProxy;

import lombok.extern.slf4j.Slf4j;
import nayoung.designpattern.JDKDynamicProxy.service.ServiceImpl;
import nayoung.designpattern.JDKDynamicProxy.service.ServiceInterface;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

@Slf4j
public class JDKDynamicProxyTest {

    @Test
    void checkProxyInfo() {
        ServiceInterface target = new ServiceImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        ServiceInterface proxy = (ServiceInterface) Proxy.newProxyInstance(ServiceInterface.class.getClassLoader(),
                new Class[]{ServiceInterface.class}, handler);

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
        proxy.find();
    }
}
