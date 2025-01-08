package com.inflearn.spring.proxy.jdkdynamic.code

import mu.KotlinLogging
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

private val log = KotlinLogging.logger {}

class TimeInvocationHandler(
    private val target: Any
) : InvocationHandler {
    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        log.info { "TimeProxy 실행" }

        val startTime = System.currentTimeMillis()

        val result = method?.invoke(target, *(args ?: emptyArray()))

        val endTime = System.currentTimeMillis()

        log.info { "TimeProxy ResultTime - ${endTime - startTime} ms" }

        return result
    }
}