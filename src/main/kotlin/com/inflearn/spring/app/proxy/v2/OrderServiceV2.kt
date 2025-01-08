package com.inflearn.spring.app.proxy.v2

import org.springframework.stereotype.Service

open class OrderServiceV2(
    private val orderRepositoryV2: OrderRepositoryV2?,
) {
    open fun orderItem(itemId: String) {
        orderRepositoryV2?.save(itemId)
    }
}