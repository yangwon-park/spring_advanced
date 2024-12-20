package com.inflearn.spring.trace.template

import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace

abstract class AbstractTemplate<T>(
    private val trace: LogTrace,
) {
    fun execute(message: String): T? {
        var status: TraceStatus? = null

        try {
            status = trace.begin(message)

            val result = call()

            trace.end(status)

            return result
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }

    abstract fun call(): T?
}