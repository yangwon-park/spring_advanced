package com.inflearn.spring.app.proxy.v1_proxy.interface_proxy

import com.inflearn.spring.app.proxy.v1.OrderRepositoryV1
import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

class OrderRepositoryInterfaceProxy(
    private val target: OrderRepositoryV1,
    private val logTrace: LogTrace,
): OrderRepositoryV1 {
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