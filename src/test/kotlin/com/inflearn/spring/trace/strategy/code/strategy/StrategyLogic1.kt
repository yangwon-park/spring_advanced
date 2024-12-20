package com.inflearn.spring.trace.strategy.code.strategy

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class StrategyLogic1 : Strategy {
    override fun call() {
        log.info { "비즈니스 로직 1 실행" }
    }
}