package com.inflearn.spring.app.v4

import com.inflearn.spring.app.v5.OrderServiceV5
import com.inflearn.spring.trace.logtrace.LogTrace
import com.inflearn.spring.trace.template.AbstractTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV4(
    private val orderServiceV5: OrderServiceV5,
    private val trace: LogTrace,
) {

    @GetMapping("/v4/request")
    fun request(itemId: String): String? {
        val template = object : AbstractTemplate<String>(trace) {
            override fun call(): String {
                orderServiceV5.orderItem(itemId)
                return "ok"
            }
        }

        return template.execute("OrderController.request()")
    }
}