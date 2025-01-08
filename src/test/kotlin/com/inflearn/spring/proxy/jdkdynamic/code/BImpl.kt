package com.inflearn.spring.proxy.jdkdynamic.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class BImpl: BInterface {
    override fun call(): String {
        log.info { "B 호출" }
        return "B"
    }
}