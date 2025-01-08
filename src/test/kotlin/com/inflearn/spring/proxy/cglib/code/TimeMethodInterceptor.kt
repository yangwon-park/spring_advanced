package com.inflearn.spring.proxy.cglib.code

import org.springframework.cglib.proxy.MethodInterceptor
import org.springframework.cglib.proxy.MethodProxy
import java.lang.reflect.Method

import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class TimeMethodInterceptor(
    private val target: Any,
) : MethodInterceptor {
    override fun intercept(obj: Any?, method: Method?, args: Array<out Any>?, proxy: MethodProxy): Any? {
        log.info { "TimeProxy 실행" }
        val startTime = System.currentTimeMillis()

        val result = proxy.invoke(target, (args ?: emptyArray())) ?: run {
            log.info { "result NULL" }
            null
        }

        val endTime = System.currentTimeMillis()

        val resultTime = endTime - startTime

        log.info { "TimeProxy 종료 $resultTime" }

        return result
    }
}