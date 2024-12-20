package com.inflearn.spring.app.v3

import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderControllerV3(
    private val orderServiceV3: OrderServiceV3,
    private val trace: LogTrace,
) {

    @GetMapping("/v3/request")
    fun request(itemId: String): String {
        var status: TraceStatus? = null

        try {
            status = trace.begin("OrderController.request()")
            orderServiceV3.orderItem(itemId)
            trace.end(status)

            return "ok"
        } catch (e: Exception) {
            trace.exception(status, e)

            throw e
        }
    }
}