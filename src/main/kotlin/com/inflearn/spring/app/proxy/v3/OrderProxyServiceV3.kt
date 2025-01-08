package com.inflearn.spring.app.proxy.v3

import org.springframework.stereotype.Service

@Service
class OrderProxyServiceV3(
    private val orderProxyRepositoryV3: OrderProxyRepositoryV3,
) {
    fun orderItem(itemId: String) {
        orderProxyRepositoryV3.save(itemId)
    }
}