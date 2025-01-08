package com.inflearn.spring.app.proxy.v1_proxy

import com.inflearn.spring.app.proxy.v1.*
import com.inflearn.spring.app.proxy.v1_proxy.interface_proxy.OrderControllerInterfaceProxy
import com.inflearn.spring.app.proxy.v1_proxy.interface_proxy.OrderRepositoryInterfaceProxy
import com.inflearn.spring.app.proxy.v1_proxy.interface_proxy.OrderServiceInterfaceProxy
import com.inflearn.spring.trace.logtrace.LogTrace
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//@Configuration
class InterfaceProxyConfig {
    @Bean
    fun orderController(logTrace: LogTrace): OrderControllerV1 {
        val controllerImpl = OrderControllerV1Impl(orderService(logTrace))

        return OrderControllerInterfaceProxy(controllerImpl, logTrace)
    }

    @Bean
    fun orderService(logTrace: LogTrace): OrderServiceV1 {
        val serviceImpl = OrderServiceV1Impl(orderRepository(logTrace))

        return OrderServiceInterfaceProxy(serviceImpl, logTrace)
    }

    @Bean
    fun orderRepository(logTrace: LogTrace): OrderRepositoryV1 {
        val repositoryImpl = OrderRepositoryV1Impl()

        return OrderRepositoryInterfaceProxy(repositoryImpl, logTrace)
    }
}