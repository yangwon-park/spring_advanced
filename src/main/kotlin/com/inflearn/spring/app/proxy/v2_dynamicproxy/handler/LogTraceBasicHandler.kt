package com.inflearn.spring.app.proxy.v2_dynamicproxy.handler

import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace
import mu.KotlinLogging
import org.springframework.util.PatternMatchUtils
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

private val log = KotlinLogging.logger {}

class LogTraceBasicHandler(
    private val target: Any,
    private val logTrace: LogTrace,
    private val patterns: Array<String>,
): InvocationHandler {
    override fun invoke(proxy: Any?, method: Method, args: Array<out Any>?): Any {
        val methodName = method.name

        if (!PatternMatchUtils.simpleMatch(patterns, methodName)) {
            return method.invoke(target, *(args ?: emptyArray()))
        }

        var status: TraceStatus? = null

        try {
            val message = method.declaringClass.simpleName + "." + methodName + "()"
            status = logTrace.begin(message)

            val result = method.invoke(target, *(args ?: emptyArray()))

            logTrace.end(status)
            
            return result
        } catch (e: Exception) {
            logTrace.exception(status, e)

            throw e
        }
    }
}