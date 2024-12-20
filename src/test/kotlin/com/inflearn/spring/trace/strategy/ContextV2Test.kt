package com.inflearn.spring.trace.strategy

import com.inflearn.spring.trace.strategy.code.strategy.ContextV2
import com.inflearn.spring.trace.strategy.code.strategy.StrategyLogic1
import com.inflearn.spring.trace.strategy.code.strategy.StrategyLogic2
import mu.KotlinLogging
import org.junit.jupiter.api.Test

private val log = KotlinLogging.logger {}

class ContextV2Test {

    /**
     * 전략 패턴 적용
     */
    @Test
    fun strategyV1() {
        val context = ContextV2()
        context.execute(StrategyLogic1())
        context.execute(StrategyLogic2())
    }

    /**
     * 전략 패턴 익명 내부 클래스
     */
    @Test
    fun strategyV2() {
        val context = ContextV2()
        context.execute { log.info { "비즈니스 로직1 실행" } }
        context.execute { log.info { "비즈니스 로직2 실행" } }
    }
}