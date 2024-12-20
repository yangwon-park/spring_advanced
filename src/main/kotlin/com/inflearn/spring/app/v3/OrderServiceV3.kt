package com.inflearn.spring.app.v3

import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV3(
    private val orderRepositoryV3: OrderRepositoryV3,
    private val trace: LogTrace,
) {
    fun orderItem(itemId: String) {
        var status:TraceStatus? = null

        try {
            status = trace.begin("OrderService.orderItem()")
            orderRepositoryV3.save(status.traceId, itemId)
            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }
}