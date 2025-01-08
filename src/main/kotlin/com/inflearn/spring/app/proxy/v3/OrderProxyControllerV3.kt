package com.inflearn.spring.app.proxy.v3

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/proxy")
class OrderProxyControllerV3(
    private val orderService: OrderProxyServiceV3
) {
    @GetMapping("/v3/request")
    fun request(itemId: String): String {
        orderService.orderItem(itemId)
        return "ok"
    }

    @GetMapping("/v3/no-log")
    fun noLog(): String {
        return "ok"
    }
}