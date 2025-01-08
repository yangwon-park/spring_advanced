package com.inflearn.spring.app.proxy.v2

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/proxy")
@RestController
class OrderControllerV2(
    private val orderServiceV2: OrderServiceV2?
) {
    @GetMapping("/v2/request")
    fun request(itemId: String): String {
        orderServiceV2?.orderItem(itemId)
        return "ok"
    }

    @GetMapping("/v2/no-log")
    fun noLog(): String {
        return "ok"
    }
}