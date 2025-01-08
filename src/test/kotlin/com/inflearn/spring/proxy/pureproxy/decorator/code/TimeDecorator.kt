package com.inflearn.spring.proxy.pureproxy.decorator.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class TimeDecorator(
    private val component: Component,
): Component {
    override fun operation(): String {
        log.info {"TimeDecorator 실행"}

        val startTime = System.currentTimeMillis()

        val result = component.operation()

        val endTime = System.currentTimeMillis()

        val resultTime = endTime - startTime

        log.info { "TimeDecorator 종료 resultTime=${resultTime}ms" }

        return result
    }
}