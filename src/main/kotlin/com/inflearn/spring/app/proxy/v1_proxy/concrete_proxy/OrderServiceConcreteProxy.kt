package com.inflearn.spring.app.proxy.v1_proxy.concrete_proxy

import com.inflearn.spring.app.proxy.v2.OrderServiceV2
import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace

class OrderServiceConcreteProxy(
    private val target: OrderServiceV2,
    private val logTrace: LogTrace,
): OrderServiceV2(null) {
    override fun orderItem(itemId: String) {
        var status: TraceStatus? = null

        try {
            status = logTrace.begin("OrderService.request()")

            // target 호출
            target.orderItem(itemId)

            logTrace.end(status)
        } catch (e: Exception) {
            logTrace.exception(status, e)
            throw e
        }
    }
}