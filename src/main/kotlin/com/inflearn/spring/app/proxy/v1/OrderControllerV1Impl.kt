package com.inflearn.spring.app.proxy.v1

class OrderControllerV1Impl(
    private val orderServiceV1: OrderServiceV1,
): OrderControllerV1 {
    override fun request(itemId: String): String {
        orderServiceV1.orderItem(itemId)
        return "ok"
    }

    override fun noLog(): String {
         return "ok"
    }
}