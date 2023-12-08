package hello.advanced.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategyMethodV0() {
        logic1();
        logic2();
    }


    private void logic1() {

        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스로직1 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }

    private void logic2() {

        long startTime = System.currentTimeMillis();
        // 비즈니스 로직 실행
        log.info("비즈니스로직2 실행");

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }
}
