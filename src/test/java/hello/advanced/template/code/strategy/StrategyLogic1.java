package hello.advanced.template.code.strategy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyLogic1 implements Strategy {

    @Override
    public void call() {

        log.info("비지니스로직1 실행");
    }
}
