package nayoung.designpattern.strategyPattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StrategyPatternTest {

    @Test
    void strategy() {
        Context context1 = new Context(() -> log.info("order logic"));
        context1.execute();

        Context context2 = new Context(() -> log.info("refund logic"));
        context2.execute();
    }
}
