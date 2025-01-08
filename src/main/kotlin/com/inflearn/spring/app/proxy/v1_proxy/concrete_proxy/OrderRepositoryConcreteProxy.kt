package com.inflearn.spring.app.proxy.v1_proxy.concrete_proxy

import com.inflearn.spring.app.proxy.v2.OrderRepositoryV2
import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace

class OrderRepositoryConcreteProxy(
    private val target: OrderRepositoryV2,
    private val logTrace: LogTrace,
): OrderRepositoryV2() {
    override fun save(itemId: String) {
        var status: TraceStatus? = null

        try {
            status = logTrace.begin("OrderRepository.request()")

            // target 호출
            target.save(itemId)

            logTrace.end(status)
        } catch (e: Exception) {
            logTrace.exception(status, e)
            throw e
        }
    }
}