package com.inflearn.spring.trace.strategy.code.strategy

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class ContextV1(
    private val strategy: Strategy,
) {
    fun execute() {
        val startTime = System.currentTimeMillis()

        strategy.call()

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }
}