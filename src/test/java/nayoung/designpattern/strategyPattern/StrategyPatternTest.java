package nayoung.designpattern.strategyPattern;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class StrategyPatternTest {

    @Test
    void strategy() {
        Strategy strategyOrder = new StrategyOrder();
        Context context1 = new Context(strategyOrder);
        context1.execute();

        Strategy strategyRefund = new StrategyRefund();
        Context context2 = new Context(strategyRefund);
        context2.execute();
    }
}
