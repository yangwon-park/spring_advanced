package com.inflearn.spring.app.proxy.v1_proxy.interface_proxy

import com.inflearn.spring.app.proxy.v1.OrderControllerV1
import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace

class OrderControllerInterfaceProxy(
    private val target: OrderControllerV1,
    private val logTrace: LogTrace
) : OrderControllerV1 {
    override fun request(itemId: String): String {
        var status: TraceStatus? = null

        try {
            status = logTrace.begin("OrderController.request()")

            // target 호출
            val result = target.request(itemId)

            logTrace.end(status)

            return result
        } catch (e: Exception) {
            logTrace.exception(status, e)
            throw e
        }
    }

    override fun noLog(): String {
        return target.noLog()
    }
}