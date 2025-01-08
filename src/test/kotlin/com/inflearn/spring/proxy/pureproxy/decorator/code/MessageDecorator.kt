package com.inflearn.spring.proxy.pureproxy.decorator.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class MessageDecorator(
    private val component: Component,
): Component {
    override fun operation(): String {
        log.info { "MessageDecorator 실행" }

        val result = component.operation()
        val decoResult= "***** $result *****"

        log.info { "꾸미기 적용 전, $result 후, $decoResult" }

        return decoResult
    }
}