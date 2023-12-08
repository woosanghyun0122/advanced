package hello.advanced.template.code.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1() {

        ContextV2 contextV2 = new ContextV2(); // ctrl + alt + v
        contextV2.execute(new StrategyLogic1());
        contextV2.execute(new StrategyLogic2());

    }

    @Test
    void strategyV2() {

        ContextV2 contextV2 = new ContextV2();
        contextV2.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1");
            }
        });
        contextV2.execute(()->log.info("비즈니스로직2"));
    }

}
