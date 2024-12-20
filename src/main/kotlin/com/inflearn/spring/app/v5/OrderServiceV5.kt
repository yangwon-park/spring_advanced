package com.inflearn.spring.app.v5

import com.inflearn.spring.trace.callback.TraceTemplate
import com.inflearn.spring.trace.logtrace.LogTrace
import org.springframework.stereotype.Service

@Service
class OrderServiceV5(
    private val orderRepositoryV5: OrderRepositoryV5,
    trace: LogTrace,
) {
    private val template: TraceTemplate = TraceTemplate(trace)

    fun orderItem(itemId: String) {
        template.execute("OrderService.orderItem()") {
            orderRepositoryV5.save(itemId)
        }
    }
}