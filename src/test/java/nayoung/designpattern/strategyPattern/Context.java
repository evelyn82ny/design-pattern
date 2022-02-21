package nayoung.designpattern.strategyPattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Context {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();
        strategy.call();
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }
}
