package com.inflearn.spring.trace.logtrace

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FieldLogTraceTest {
     private val trace = FieldLogTrace()

    @Test
    fun begin_end_test() {
        val status1 = trace.begin("hello1")
        val status2 = trace.begin("hello2")
        trace.end(status2)
        trace.end(status1)
    }

    @Test
    fun begin_exception_test() {
        val status1 = trace.begin("hello1")
        val status2 = trace.begin("hello2")
        trace.exception(status2, IllegalStateException())
        trace.exception(status1, IllegalStateException())
    }
}