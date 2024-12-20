package com.inflearn.spring.app.v4

import com.inflearn.spring.trace.logtrace.LogTrace
import com.inflearn.spring.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV4(
    private val trace: LogTrace,
) {
    fun save(itemId: String) {
        val template = object : AbstractTemplate<String>(trace) {
            override fun call(): Nothing? {
                if (itemId == "ex") {
                    throw IllegalArgumentException("예외")
                }

                sleep(1000)

                return null
            }
        }

        template.execute("OrderRepository.save()")
    }
}