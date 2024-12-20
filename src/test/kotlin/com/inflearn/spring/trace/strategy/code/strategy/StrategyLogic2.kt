package com.inflearn.spring.trace.strategy.code.strategy

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class StrategyLogic2 : Strategy {
    override fun call() {
        log.info { "비즈니스 로직 2 실행" }
    }
}