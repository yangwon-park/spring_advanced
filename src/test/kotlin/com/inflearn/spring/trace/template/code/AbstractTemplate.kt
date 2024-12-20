package com.inflearn.spring.trace.template.code

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

abstract class AbstractTemplate {
    fun execute() {
        val startTime = System.currentTimeMillis()

        call()

        val endTime = System.currentTimeMillis()
        val resultTime = endTime - startTime

        log.info { "resultTime=$resultTime" }
    }

    protected abstract fun call();
}