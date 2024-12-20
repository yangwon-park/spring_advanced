package com.inflearn.spring.trace

data class TraceStatus(
    val traceId: TraceId,
    val startTimeMs: Long,
    val message: String,
) {

}