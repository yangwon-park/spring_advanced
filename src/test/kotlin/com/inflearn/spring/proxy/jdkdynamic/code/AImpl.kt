package com.inflearn.spring.proxy.jdkdynamic.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class AImpl: AInterface {
    override fun call(): String {
        log.info { "A 호출" }
        return "A"
    }
}