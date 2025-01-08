package com.inflearn.spring.app.proxy.v1_proxy.concrete_proxy

import com.inflearn.spring.app.proxy.v2.OrderControllerV2
import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace

class OrderControllerConcreteProxy(
    private val target: OrderControllerV2,
    private val logTrace: LogTrace,
): OrderControllerV2(null) {
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