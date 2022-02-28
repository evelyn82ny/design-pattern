package nayoung.designpattern;

import nayoung.designpattern.config.AppV2ConcreteProxyConfig;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(AppV2ConcreteProxyConfig.class)
@SpringBootApplication(scanBasePackages = "nayoung.designpattern.app.proxy")
public class DesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
