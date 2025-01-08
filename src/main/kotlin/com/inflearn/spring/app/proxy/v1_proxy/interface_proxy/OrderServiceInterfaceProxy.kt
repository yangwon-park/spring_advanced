package com.inflearn.spring.app.proxy.v1_proxy.interface_proxy

import com.inflearn.spring.app.proxy.v1.OrderServiceV1
import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace

class OrderServiceInterfaceProxy(
    private val target: OrderServiceV1,
    private val logTrace: LogTrace,
) : OrderServiceV1 {
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