package com.inflearn.spring.trace.config

import com.inflearn.spring.trace.logtrace.LogTrace
import com.inflearn.spring.trace.logtrace.ThreadLogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LogTraceConfig {

    @Bean
    fun logTrace(): LogTrace {
        return ThreadLogTrace()
    }
}