package com.inflearn.spring.trace.template.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class SubClassLogic1: AbstractTemplate() {
    override fun call() {
        log.info { "비즈니스 로직1 실행" }
    }
}