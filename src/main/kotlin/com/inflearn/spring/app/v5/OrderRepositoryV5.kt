package com.inflearn.spring.app.v5

import com.inflearn.spring.trace.callback.TraceTemplate
import com.inflearn.spring.trace.logtrace.LogTrace
import com.inflearn.spring.trace.template.AbstractTemplate
import org.springframework.stereotype.Repository
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV5(
    private val trace: LogTrace,
) {
    private val template: TraceTemplate = TraceTemplate(trace)

    fun save(itemId: String) {
        template.execute("OrderRepository.save()") {
            if (itemId == "ex") {
                throw IllegalArgumentException("예외")
            }

            sleep(1000)
        }
    }
}