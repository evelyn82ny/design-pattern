package nayoung.designpattern;

import nayoung.designpattern.config.postprocessor.AutoProxyConfig;
import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(AutoProxyConfig.class)
@SpringBootApplication(scanBasePackages = "nayoung.designpattern.app")
public class DesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesignPatternApplication.class, args);
    }

    @Bean
    public LogTrace logTrace() {
        return new ThreadLocalLogTrace();
    }
}
