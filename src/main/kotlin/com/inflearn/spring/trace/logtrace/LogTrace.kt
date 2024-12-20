package com.inflearn.spring.trace.logtrace

import com.inflearn.spring.trace.TraceStatus

interface LogTrace {
    fun begin(message: String): TraceStatus
    fun end(status: TraceStatus)
    fun exception(status: TraceStatus?, e: Exception)
}