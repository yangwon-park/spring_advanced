package com.inflearn.spring.trace.strategy

import com.inflearn.spring.trace.strategy.code.strategy.ContextV1
import com.inflearn.spring.trace.strategy.code.strategy.Strategy
import com.inflearn.spring.trace.strategy.code.strategy.StrategyLogic1
import com.inflearn.spring.trace.strategy.code.strategy.StrategyLogic2
import mu.KotlinLogging
import org.junit.jupiter.api.Test

private val log = KotlinLogging.logger {}

class ContextV1Test {

    @Test
    fun strategyV0() {
        logic1()
        logic2()
    }

    private fun logic1() {
        val startTime = System.currentTimeMillis()

        log.info { "비즈니스 로직1 실행" }

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }

    private fun logic2() {
        val startTime = System.currentTimeMillis()

        log.info { "비즈니스 로직2 실행" }

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }

    /**
     * 전략 패턴 사용
     */
    @Test
    fun strategyV1() {
        val strategyLogic1 = StrategyLogic1()
        val context1 = ContextV1(strategyLogic1)
        context1.execute()

        val strategyLogic2 = StrategyLogic2()
        val context2 = ContextV1(strategyLogic2)
        context2.execute()
    }

    /**
     * 익명 내부 클래스 활용
     *      => StrategyLogic 클래스 생성 불필요
     */
    @Test
    fun strategyV2() {
        val strategyLogic1 = object : Strategy {
            override fun call() {
                log.info { "비즈니스 로직1 실행" }
            }
        }

        val context1 = ContextV1(strategyLogic1)
        log.info { "logic1 :: ${strategyLogic1.javaClass}" }
        context1.execute()

        val strategyLogic2 = object : Strategy {
            override fun call() {
                log.info { "비즈니스 로직1 실행" }
            }
        }

        val context2 = ContextV1(strategyLogic2)
        log.info { "logic2 :: ${strategyLogic2.javaClass}" }
        context2.execute()
    }

    /**
     * 익명 내부 클래스 보다 편하게 활용
     *      => StrategyLogic 클래스 생성 불필요
     *      => Context 생성 시점에 Strategy 구현체를 직접 선언
     */
    @Test
    fun strategyV3() {
        val context1 = ContextV1(
            object : Strategy {
                override fun call() {
                    log.info { "비즈니스 로직1 실행" }
                }
            })

        context1.execute()

        val context2 = ContextV1(
            object : Strategy {
                override fun call() {
                    log.info { "비즈니스 로직1 실행" }
                }
            })

        context2.execute()
    }

    /**
     * 익명 내부 클래스 보다 편하게 활용
     *      => StrategyLogic 클래스 생성 불필요
     *      => Context 생성 시점에 Strategy 구현체를 직접 선언
     *      => Lambda로 대체 (fun interface)
     */
    @Test
    fun strategyV4() {
        val context1 = ContextV1 { log.info { "비즈니스 로직1 실행" } }
        context1.execute()

        val context2 = ContextV1 { log.info { "비즈니스 로직1 실행" } }
        context2.execute()
    }
}