package com.inflearn.spring.proxy.pureproxy.proxy.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class CacheProxy(
    private val target: Subject, // proxy가 호출하는 실제 객체
): Subject {
    private var cacheValue: String? = null

    override fun operation(): String? {
        log.info { "프록시 호출" }

        if (cacheValue == null) {
            cacheValue = target.operation()
        }

        return cacheValue
    }
}