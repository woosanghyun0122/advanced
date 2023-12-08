package hello.advanced.template.code;

import hello.advanced.template.code.strategy.ContextV1;
import hello.advanced.template.code.strategy.Strategy;
import hello.advanced.template.code.strategy.StrategyLogic1;
import hello.advanced.template.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * 필드에 전략을 보관하는 방식
 * 변하지 않는 로직을 가지고 있는 템플릿 역할
 */
@Slf4j
public class ContextV1Test {


    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic1);
        contextV2.execute();
    }

    @Test
    void strategyV2() {

        Strategy strategy1 = new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직1 실행");
            }
        };
        ContextV1 contextV1 = new ContextV1(strategy1);
        contextV1.execute();

        Strategy strategy2 = new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        };
        ContextV1 contextV2 = new ContextV1(strategy2);
        contextV2.execute();
    }

    @Test
    void strategyV3() {

        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직1 실행");
            }
        });
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직2 실행");
            }
        });
        contextV2.execute();
    }

    @Test
    void strategyV4() {



        ContextV1 contextV1 = new ContextV1(() -> log.info("비지니스 로직1 실행"));
        contextV1.execute();

        ContextV1 contextV2 = new ContextV1(() -> log.info("비지니스 로직2 실행"));
        contextV2.execute();
    }
}




