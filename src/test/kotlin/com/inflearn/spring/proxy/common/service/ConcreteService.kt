package com.inflearn.spring.proxy.common.service

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

open class ConcreteService {
    open fun call() {
        log.info { "ConcreteService 호출" }
    }
}