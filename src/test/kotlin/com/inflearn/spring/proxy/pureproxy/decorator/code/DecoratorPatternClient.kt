package com.inflearn.spring.proxy.pureproxy.decorator.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class DecoratorPatternClient(
    private val component: Component,
) {
    fun execute() {
        val result = component.operation()

        log.info { "result = $result" }
    }
}