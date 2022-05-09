package nayoung.designpattern.CGLIB;

import lombok.extern.slf4j.Slf4j;
import nayoung.designpattern.CGLIB.service.ConcreteService;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTest {

    @Test
    void CGLIB() {
        ConcreteService target = new ConcreteService();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(ConcreteService.class);
        enhancer.setCallback(new TimeMethodInterceptor(target));

        ConcreteService proxy = (ConcreteService) enhancer.create();
        log.info("target class = {}", target.getClass());
        log.info("proxy class = {}", proxy.getClass());

        proxy.call();
    }
}
