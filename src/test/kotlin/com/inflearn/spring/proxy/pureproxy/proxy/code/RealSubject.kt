package com.inflearn.spring.proxy.pureproxy.proxy.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class RealSubject: Subject {
    override fun operation(): String {
        log.info { "실제 객체 호출" }
        sleep(1000)
        return "data"
    }

    private fun sleep(millis: Int) {
        try {
            Thread.sleep(millis.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}