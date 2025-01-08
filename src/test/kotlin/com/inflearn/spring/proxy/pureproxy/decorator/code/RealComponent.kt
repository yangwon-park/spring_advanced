package com.inflearn.spring.proxy.pureproxy.decorator.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class RealComponent: Component {
    override fun operation(): String {
        log.info { "RealComponent 실행" }

        return "data"
    }
}