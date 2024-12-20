package com.inflearn.spring.app.v4

import com.inflearn.spring.trace.logtrace.LogTrace
import com.inflearn.spring.trace.template.AbstractTemplate
import org.springframework.stereotype.Service

@Service
class OrderServiceV4(
    private val orderRepositoryV4: OrderRepositoryV4,
    private val trace: LogTrace,
) {
    fun orderItem(itemId: String) {
        val template = object : AbstractTemplate<String>(trace) {
            override fun call(): Nothing? {
                orderRepositoryV4.save(itemId)

                return null
            }
        }

        template.execute("OrderService.orderItem()")
    }
}