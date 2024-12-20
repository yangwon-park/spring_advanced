package com.inflearn.spring.trace.strategy.code.template

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class TimeLogTemplate {
    fun execute(callback: Callback) {
        val startTime = System.currentTimeMillis()

        callback.call()

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }
}