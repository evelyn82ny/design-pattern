package nayoung.designpattern.strategyPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyRefund implements Strategy {

    @Override
    public void call() {
        log.info("refund logic");
    }
}
