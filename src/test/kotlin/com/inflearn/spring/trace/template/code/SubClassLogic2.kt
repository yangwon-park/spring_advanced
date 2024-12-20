package com.inflearn.spring.trace.template.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class SubClassLogic2: AbstractTemplate() {
    override fun call() {
        log.info { "비즈니스 로직2 실행" }
    }
}