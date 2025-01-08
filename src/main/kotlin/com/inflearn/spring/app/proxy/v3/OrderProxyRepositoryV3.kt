package com.inflearn.spring.app.proxy.v3

import org.springframework.stereotype.Repository

@Repository
class OrderProxyRepositoryV3 {
    fun save(itemId: String) {
        if (itemId == "ex") {
            throw IllegalArgumentException("예외")
        }

        sleep(1000)
    }

    private fun sleep(mills: Long) {
        try {
            Thread.sleep(mills)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}