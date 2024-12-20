package com.inflearn.spring.app.v5

import com.inflearn.spring.trace.callback.TraceTemplate
import com.inflearn.spring.trace.logtrace.LogTrace
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

private val log = KotlinLogging.logger {}

@RestController
class OrderControllerV5(
    private val orderServiceV5: OrderServiceV5,
    private val trace: LogTrace,
) {
    private val template: TraceTemplate = TraceTemplate(trace)

    @GetMapping("/v5/request")
    fun request(itemId: String): String? {
        return template.execute("OrderController.request()") {
            orderServiceV5.orderItem(itemId)
            "ok"
        }
    }
}