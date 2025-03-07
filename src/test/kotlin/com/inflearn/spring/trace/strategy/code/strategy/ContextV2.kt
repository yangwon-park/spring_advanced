package com.inflearn.spring.trace.strategy.code.strategy

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

/**
 * 전략을 파라미터로 전달 받는 방식
 */
class ContextV2 {
    fun execute(strategy: Strategy) {
        val startTime = System.currentTimeMillis()

        strategy.call()

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }
}