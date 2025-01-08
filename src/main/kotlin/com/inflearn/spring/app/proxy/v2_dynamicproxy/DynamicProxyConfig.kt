package com.inflearn.spring.app.proxy.v2_dynamicproxy

import com.inflearn.spring.app.proxy.v1.*
import com.inflearn.spring.app.proxy.v2_dynamicproxy.handler.LogTraceBasicHandler
import com.inflearn.spring.trace.logtrace.LogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.lang.reflect.Proxy

@Configuration
class DynamicProxyConfig {
    @Bean
    fun orderControllerV1(logTrace: LogTrace): OrderControllerV1 {
        val orderController = OrderControllerV1Impl(orderServiceV1(logTrace))

        val proxy = Proxy.newProxyInstance(
            OrderControllerV1::class.java.classLoader,
            arrayOf(OrderControllerV1::class.java),
            LogTraceBasicHandler(orderController, logTrace, PATTERNS)
        ) as OrderControllerV1

        return proxy
    }

    @Bean
    fun orderServiceV1(logTrace: LogTrace): OrderServiceV1 {
        val orderService = OrderServiceV1Impl(orderRepositoryV1(logTrace))

        val proxy = Proxy.newProxyInstance(
            OrderServiceV1::class.java.classLoader,
            arrayOf(OrderServiceV1::class.java),
            LogTraceBasicHandler(orderService, logTrace, PATTERNS)
        ) as OrderServiceV1

        return proxy
    }

    @Bean
    fun orderRepositoryV1(logTrace: LogTrace): OrderRepositoryV1 {
        val orderRepository = OrderRepositoryV1Impl()

        val proxy = Proxy.newProxyInstance(
            OrderRepositoryV1::class.java.classLoader,
            arrayOf(OrderRepositoryV1::class.java),
            LogTraceBasicHandler(orderRepository, logTrace, PATTERNS)
        ) as OrderRepositoryV1

        return proxy
    }

    companion object {
        private val PATTERNS = arrayOf("request*", "order*", "save*")
    }
}