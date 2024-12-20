package com.inflearn.spring.app.v3

import com.inflearn.spring.trace.TraceId
import com.inflearn.spring.trace.TraceStatus
import com.inflearn.spring.trace.logtrace.LogTrace
import org.springframework.stereotype.Repository
import java.lang.Thread.sleep

@Repository
class OrderRepositoryV3(
    private val trace: LogTrace,
) {
    fun save(traceId: TraceId, itemId: String) {
        var status: TraceStatus? = null

        try {
            status = trace.begin("OrderRepository.save()")

            if (itemId == "ex") {
                throw IllegalArgumentException("예외")
            }

            sleep(1000)

            trace.end(status)
        } catch (e: Exception) {
            trace.exception(status, e)
            throw e
        }
    }
}